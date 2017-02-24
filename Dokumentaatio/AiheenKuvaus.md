#Aihe
Toteutetaan Asteroidit- peli. Siinä pelaaja voi liikuttaa avaruusalustaan kaikkiin suuntiin tuhoten samalla asteroideja aluksen ammuksilla. Tarkoituksena on pisteiden keruu ja elossa säilyminen mahdollisimman pitkään. Kun pelaaja osuu ammuksella asteroidiin, asteroidi hajoaa kahdeksi pienemmäksi palaseksi. Asteroidin saa tuhottua kun se on tarpeeksi pieni. Pelaaja menettää yhden aluksen osuessaan asteroidiin. Peli loppuu kun pelaajalla ei ole enää aluksia jäljellä. Ohjelma toteutetaan Java-kielellä.

**Käyttäjät**: Pelaaja

**Toiminnot**: 
 - Pelaaja liikkuu nuolinäppäimillä pelialustalla eri suuntiin.
  - Jos pelaaja liikkuu pelialueen yli, alus pomppaa ruudun toiseen päähän
 - Pelaaja ampuu ammuksia välilyönnillä.
  - Jos ammus osuu asteroidiin, se puolittuu ja pelaajan pisteet kasvaa
 - Pelaaja törmää asteroidiin.
  - Pelaaja menettää yhden aluksen.

**Rakenne**:
Käyttöliittymällä on myös oma näppäimistönkuuntelija sekä piirtoalusta. Piirtoalusta käyttää Asteroids-luokkaa sen olioiden piirtämiseen. Asteroids-luokalla on oma näppäimistönkuuntelija, mikä kuuntelee pelaajan näppäinkomentoja ja ohjaa niillä Alus-luokkaa. Asteroids luokalla on myös lista sen käyttämiä asteroideja sekä Alus. Aluksella taas on lista sen käyttämiä Ammus-oliota.

#Luokkakaavio
![Määrittelyvaiheen luokkakaavio](/Dokumentaatio/Asteroidikaavio.png)
#Käyttötapaus: Välilyönti
![Sekvenssikaavio välilyönti] (/Dokumentaatio/Valilyonti.png)
#Käyttötapaus: Ylänuoli
![Sekvenssikaavio ylänuoli] (/Dokumentaatio/Ylanuoli.png)




