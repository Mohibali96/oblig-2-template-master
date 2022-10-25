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

Oppgave 4: 
Starter med å sjekke om verdien er null, hvis den er det returneres -1. Deretter bruker jeg en hjelpevariabel som jeg
setter den til hode. så bruker jeg en forloop for å gå gjennom listen som  sammenligner verdien til hjelpevariabelen med
variabelen som kommer som argument. når verdien er lik returneres indeksen til verdien. 
Dersom den ikke blir funnet returneres -1. 

oppgave 5:
Starter med å sjekke om verdien som kommer inn som argumen er null, kaster en exception dersom den er. Deretter sjekker
kontrollerer vi indeksen for å sjekke om den er mindre enn null eller større enn antall. Deretter sjekker vi om listen
er tom og indeks er null. Dersom den er setter vi både hode og hale peker til den. Etter det sjekker jeg indeksen er den
siste, hvis den er setter jeg bytter jeg pekeren til hale og setter den nye noden som hale og gjør det samme med hodet, 
dersom indeks er null og listen ikke er tom settes den nye noden til hodet og bytter pekeren. 
Dersom ingen av disse er tilfelle må ny node legges i midten, vi looper da gjennom listen og pekeren blir satt til 
hjelpevariabel.neste i hver iterasjon. Loopen stopper når vi treffer indeksen og vil hjelpevariabel.neste være indeksen
vi skal legge noden i, da setter vi temp.neste til ny node og pekeren byttes til forrige og neste node. Til slutt øker 
antall og endringer med 1. 

Oppgave 6:
Vi starter med å sjekke om indeksen som skal fjernes er gyldig, dette ved hjelp av indekskontroll. Deretter sjekker vi 
indeksen er den første i listen. Dersom den er det første bytter vi hode pekerne og setter hode til hode.neste.
Også sjekker vi om det finnes elementer etter hode, dersom det ikke gjør det blir hode og hale satt til null. Deretter 
sjekker vi om indeksen er siste elementet, hvis den er byttes halen og hale pekerne. Hvis ikke ligger den i midten, så 
looper vi gjennom listen og til vi kommer frem til indeksen vi skal fjerne og bytter pekerne til forrige og neste node.
Etter å ha funnet verdien som skal fjernes i hvert tilfelle så lagrer vi verdien i en hjelpevariabel, og deretter 
returneres den etter å ha økt endringer og antall med 1.

Boolean fjern metoden er omtrent det samme som forrige, forskjellen er at vi sjekker om verdien til noden er den samme 
som verdien som kommer inn som argument. Dersom den er det så bytter vi pekere basert på hvor den ligger i listen, til 
slutt minker vi antall med 1 og returnerer verdien som blir fjernet fra listen. 
