### Mitä algoritmeja ja tietorakenteita toteutat työssäsi
Algoritmina toimii alpha-beta karsinta, joka on jalostettu versio minimax karsinnasta. Tähän tarvitaan tietorakenteeksi hakupuu. Lisäksi kehittelen jotain ajankäytön optimointiin liittyvää, jos kerkeän.

### Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet
Teen shakkitekoälyn. Valitsin kyseisen algoritmin ja tietorakenteen, koska lähes kaikki shakkitekoälyt perustuvat niihin. Lisäksi Alpha-beta karsintaa on käyty lävitse aikaisemmilla kursseilla, joten se on jokseenkin tuttu, mutta sopivan vieras (vielä).

### Mitä syötteitä ohjelma saa ja miten näitä käytetään
Tekoälyä pitäisi pystyä pelaamaan vastaan lichess.com verkkosivulla. Jos kurssilla joku toinen tekee shakkitekoälyn, pitäisi myös pystyä pistämään ne pelaamaan vastakkain (tai tietysti itseään tai jotain tunnettua tekoälyä vastaan).

### Tavoitteena olevat aika- ja tilavaativuudet (m.m. O-analyysit)
Alpha-beta karsinnan aikavaativuus on pahimmillaan O(b^d) ja parhaimmillaan tämän neliöjuuri (wikipedia). b = kuinka moneen haaraan pelitilanteet jakautuvat d = puun syvyys.
Tilavaativuus on O(b*d). Nähin tähtään.

### Lähteet
https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning
