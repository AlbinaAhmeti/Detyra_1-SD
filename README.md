# Detyra_1-SD
Detyra e parë në Siguria e të dhënave 2021.
Enkriptimi dhe dekriptimi përmes Playfair Cipher në Java.

Kriptimi Playfair

Njeri nder algoritmet kriptografike me te njohura shume-shkronjeshe eshte Playfair. Principi i punes se ketij algoritmi bazohet ne matricen 5x5 ne te cilen jane vendose shkronjat e alfabetit, e cila konstruktohet sipas nje celesi (angl. Key). 
Vini re se çdo alfabet nuk duhet të përsëritet. Një pikë tjetër për të theksuar se ka 26 alfabete dhe ne kemi vetëm 25 blloqe për të vendosur një letër brenda saj.
Prandaj, një shkronjë është e tepërt, kështu që një shkronjë do të hiqet (zakonisht J) nga matrica. Sidoqoftë, teksti i thjeshtë përmban J, atëherë J zëvendësohet nga I.
Kjo do të thotë të trajtoj I dhe J si të njëjtën letër, përkatësisht.

Kufizimet e  Playfair Cipher:

- Vetëm 25 alfabete mbështeten.
- Nuk mbështet karaktere numerike.
- Vetëm rastet e mëdha ose të vogla mbështeten.
- Ndalohet përdorimi i karaktereve speciale (të tilla si hapësira boshe, vija e re, pikësimet, etj.).
- Nuk mbështet gjuhë të tjera, përveç anglishtes.
- Kriptimi i skedarëve të medias gjithashtu nuk mbështetet.


Enkriptimi shkon sipas procesit ne vijim

Fillimisht largohen te gjithe karakteret qe nuk gjenden ne matricen e celesit. Pastaj ndahet teksti per enkriptimi ne grupe me nga 2 karaktere. Nese karakteret jane te njejta atehere karakteri i dyte zevendesohet me shkonjen X. Nese numri i karaktereve eshte tek atehere i shtohet ne fund shkronja X. Pasi qe ndahet ne karaktere, kontrollohet pozita e secilit grupacion dhe behet enkriptimi sipas rregullave ne vijim:
1.	Nese gjinden ne rreshta te njejte atehere merret elementi pasues; nese eshte ne kolonen e fundit atehere merret elementi i pare.
2.	Nese gjinden ne kolona te njejta atehere merret elementi i rreshtit pasues por i kolones se njejte; nese eshte ne rreshtin e fundit atehere merret elementi i rreshtit te pare te kolones se njejte.
3.	Nese gjinden ne rreshta dhe kolona te ndryshme atehere merret elementi i rreshtit te njejte por i kolones se karakterit/shkronjes tjeter.
