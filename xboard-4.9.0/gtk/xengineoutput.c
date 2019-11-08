/*
 * Engine output (PV)
 *
 * Author: Alessandro Scotti (Dec 2005)
 *
 * Copyright 2005 Alessandro Scotti
 *
 * Enhancements Copyright 2009, 2010, 2011, 2012, 2013, 2014, 2015,
 * 2016 Free Software Foundation, Inc.
 *
 * ------------------------------------------------------------------------
 *
 * GNU XBoard is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * GNU XBoard is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses/.
 *
 * ------------------------------------------------------------------------
 ** See the file ChangeLog for a revision history.  */

#include "config.h"

#include <stdio.h>
#include <ctype.h>
#include <errno.h>
#include <sys/types.h>

#if STDC_HEADERS
# include <stdlib.h>
# include <string.h>
#else /* not STDC_HEADERS */
extern char *getenv();
# if HAVE_STRING_H
#  include <string.h>
# else /* not HAVE_STRING_H */
#  include <strings.h>
# endif /* not HAVE_STRING_H */
#endif /* not STDC_HEADERS */

#if HAVE_UNISTD_H
# include <unistd.h>
#endif

#include <gtk/gtk.h>

#include "common.h"
#include "frontend.h"
#include "backend.h"
#include "dialogs.h"
#include "xboard.h"
#include "engineoutput.h"
#include "gettext.h"

#ifdef ENABLE_NLS
# define  _(s) gettext (s)
# define N_(s) gettext_noop (s)
#else
# define  _(s) (s)
# define N_(s)  s
#endif

extern Option engoutOptions[]; // must go in header, but which?

/* Module variables */
#ifdef TODO_GTK
static Widget memoWidget;
#endif
static GdkPixbuf *iconsGTK[8];

static void
ReadIcon (gchar *svgFilename, int iconNr)
{
    iconsGTK[iconNr] = LoadIconFile(svgFilename);
}

void
InitEngineOutput (Option *opt, Option *memo2)
{	// front-end, because it must have access to the pixmaps
#ifdef TODO_GTK
	Widget w = opt->handle;
	memoWidget = memo2->handle;
#endif
    ReadIcon("eo_White", nColorWhite);
    ReadIcon("eo_Black", nColorBlack);
    ReadIcon("eo_Unknown", nColorUnknown);

    ReadIcon("eo_Clear", nClear);
    ReadIcon("eo_Ponder", nPondering);
    ReadIcon("eo_Thinking", nThinking);
    ReadIcon("eo_Analyzing", nAnalyzing);
}

void
DrawWidgetIcon (Option *opt, int nIcon)
{   // as we are already in GTK front-end, so do GTK-stuff here
    if( nIcon != 0 ) gtk_image_set_from_pixbuf(GTK_IMAGE(opt->handle), GDK_PIXBUF(iconsGTK[nIcon]));
}

void
InsertIntoMemo (int which, char * text, int where)
{
    char *p;
    GtkTextIter start;

    /* the backend adds \r\n, which is needed for winboard,
     * for xboard we delete them again over here */
    if(p = strchr(text, '\r')) *p = ' ';

    GtkTextBuffer *tb = (GtkTextBuffer *) (engoutOptions[which ? 12 : 5].handle);
//    gtk_text_buffer_get_start_iter(GTK_TEXT_BUFFER(tb), &start);
    gtk_text_buffer_get_iter_at_offset(tb, &start, where);
    gtk_text_buffer_insert(tb, &start, text, -1);
    if(where < highTextStart[which]) { // [HGM] multiPVdisplay: move highlighting
	int len = strlen(text);
	highTextStart[which] += len; highTextEnd[which] += len;
    }
}

//------------------------------- pane switching -----------------------------------

void
ResizeWindowControls (int mode)
{   // another hideous kludge: to have only a single pane, we resize the
    // second to 5 pixels (which makes it too small to display anything)
    if(mode) gtk_widget_show(engoutOptions[13].handle);
    else     gtk_widget_hide(engoutOptions[13].handle);
}
