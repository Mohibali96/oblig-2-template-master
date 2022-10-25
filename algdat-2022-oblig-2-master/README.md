# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Mohib Ali - S362040

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Denne oppgaven er løst på egenhånd.

# Oppgavebeskrivelse
  Oppgave 1:
Jeg lager en dobbeltlinket liste. Sjekker tabellen og kaster en exception hvis den er null. 
Deretter velger jeg å gi hode en verdi og det er første ikke null verdien. 
Jeg går gjennom alle ikke null verdier og setter halen til slutt. 

Oppgave 2:
Jeg bruker stringbuilder for å legge til verdiene i listen. Jeg sjekker om listen er tom eller ikke, hvis den er
blir det lagt til en tom parantes, hvis ikke legger jeg til verdien til hode og en komme og starter loopen. 
Loopen repeteres frem til ikke hode.neste er null, loopen starter med hode.neste og legger til alle ikke null verdier,
deretter flyttes pekeren til neste. 

Brukte samme konsept som i oppgave 1a i omvendt streng. 

Oppgave 3: 
Vi får inn en indeks som argument i finn node deretter sjekker vi om den ligger nærmere hode eller hale. 
Dersom den ligger nærmere hode skal pekeren settes til hode.neste i hver iterasjon av loopen, stopper loopen når
int i > indeks, da er hjelpevariabelen.neste på riktig plass. Til slutt henter vi ut noden som ligger på den plassen. 
Dersom indeksen ligger nærmere halen så bruker vi samme konsept, forskjellen blir da at hjelpevariabelen starter på hale
og pekeren blit satt til hale.forrige helt til int i > indeks. Til slutt ble noden retunert. 

Vi bruker objects.requirenonnull i metoden oppdater, dette for å sjekke om verdien vi skal sette inn er null. Deretter 
henter vi inn gammel verdi ved hjelp av finn node, lagrer den i en hjelpevariabel. Til slutt bytter vi gammel verdi med 
ny verdi og retunerer gammel verdi. 

I subliste metoden lager jeg en hjelpemetode for å kontrollere argumenter. Deretter lager jeg en ny dobbeltlinket liste 
der jeg bruker konstruktør og kaller på finn node metode fra posisjon og setter den som hode. 
Legginn metoden brukes for å sette inn verdier basert på lengden til listen. 

Etter hver innleggelse tar jeg lengde-- og setter pekeren til hjelpevariabel.neste. 
