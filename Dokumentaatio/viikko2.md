#### Mitä olen tehnyt tällä viikolla?

Latasin ohtuprojektina tehdyn rungon tekoälyn testaamiseen. Nyt shakkibottia pystyy testaamaan joko lichessissä tai xboardilla. Tein nappuloiden siirtologiikkaa, jotta pystyn generoimaan puun, jota sitten käydään läpi alpha-beta karsinnalla. Suurin osa ajasta meni luokkien suunnitteluun ja algoritmien tutkiskeluun (jotta ohjelman rakenteesta tulisi järkevä).

#### Miten ohjelma on edistynyt?

Mielestäni on valtava homma generoida kaikki mahdolliset siirrot. Ohtuprojektissa sanotaan, että on tiralabran suorittajan vastuulla tehdä itse siirtologiikat. Tuntuu, että tähän osuuteen juuri menee kaikista eniten aikaa. Siis vielä on tosi paljon tehtävää. Koodi ei myöskään ole mielestäni siinä kunnossa, että mitkään testailut olisi järkeviä. Vasta kun saan siirtologiikat tehty, pystyn vertailemaan miten ne toimivat. Pystyn vertaamaan niitä TestBot:issa käytettyyn valmiiseen luokkaan, joka generoi kaikki mahdolliset siirrot. Ensi viikolla keskityn enemmin itse algoritmin toteuttamiseen (käyttäen siirtojen generoimiseen valmista luokkaa). Näen tämän oleellisimpana osana ohjelmaa, joten jätän siirtologiikoiden generoimisen myöhempään.

#### Mitä opin tällä viikolla / tänään?

Opin käyttämään ohtuprojektina tehtyä shakkitekoäly-alustaa. Opin myös miten shakkitekoälyt toimivat pääpiirteittäin (perinteiset minimax/alpha-betaan perustuvat). Puun läpikäynti toteutetaan alphabetalla ja riippuen kuinka paljon aikaa on, pitää algoritmin osata päättää kuinka syvälle puuhun se laskee (progressive deepening). Tämä johtaa siihen, että algoritmi antaa aina jonkin vastauksen. Lisäksi algoritmin olisi hyvä osata huomata tärkeät osat puuta. Esimerkiksi haaran joka tulee päättymään parin siirron päästä shakkimattiin. Tätä kutsutaan "uneven tree development". Eli algoritmi ei käy kaikki haaroja yhtä syvälle läpi. Lisäksi nopeutta lisätään aloituskirjalla, loppupeli taktiikoilla ja rinnakkaisella laskennalla. Nämä viimiset jäävät varmasti tämän kurssin ulkopuolelle.

#### Mikä jäi epäselväksi tai tuottanut vaikeuksia? Vastaa tähän kohtaan rehellisesti, koska saat tarvittaessa apua tämän kohdan perusteella.

On vielä epäselvyyksiä miten itse puun rakennan. Lisäksi siirtoalgoritmit ovat yllättävän monimutkaisia (pitää siis ottaa kaikki huomiion).

#### Mitä teen seuraavaksi?

Seuraavaksi generoin siirrot valmiilla algoritmilla ja yritän muodostaa pelipuun, jota pystyy käymään läpi. 

Aikaa kului 10h
