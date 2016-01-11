# VanGogu
Repository-ul pentru proiectul #2 (Van'Gogu) de la Management-ul Proiectelor Software

Echipa:

Technical Writer

    Dragomir Dragos, 341C5 https://ro.linkedin.com/in/dragosddragomir/en
    Gruia Iulia Mihaela, 341C5 https://ro.linkedin.com/in/iulia-mihaela-gruia-343b1560/en
    Nedelcu Daria, 341C5 https://www.linkedin.com/in/daria-nedelcu-298b5270

Developers:

    Ionel Laura, 342C5 https://ro.linkedin.com/in/laura-ionel-039ab3b4
    Volmer Mihai, 341C1 https://ro.linkedin.com/in/mihai-cristian-volmer-881824a7

Testers

    Popescu Teodor, 341C5 https://ro.linkedin.com/in/doru-popescu-8b4296102
    Andreea Bruma, 341C5 https://ro.linkedin.com/in/andreea-brumă-45238610a/en

Caruselul Literelor a fost conceput ca o aplicatie Android mobile

Cerinta:

http://elf.cs.pub.ro/mps/wiki/proiect/proiect-2

Tehnologii folosite:

    Java
    Java Swing

Scopul aplicatiei:

Aplicatia isi propune sa obtina o imagine cu o valoare “artistica” de un cat mai ridicat nivel de exprimare utilizand doar generare procedurala, geometrie fractalica, si algoritmica simpla intr-un interval de timp maxim de 60 de secunde. 



Pasi configurare mediu de dezvoltare (IntelliJ IDEA): --clone de pe Git--

    Check out from Version Control -> GitHub -> Git Repository URL -> Clone -> Create project from existing sources -> Next -> Next-> Next -> Next -> Next -> Next -> Finish


   
<b>Modulele aplicatiei:</b>

1. MainClass.java - Initilizeaza aplicatia Java
                  - Instantiaza celelalte module si face legatura intre ele
                  - Asigura efectul de animatie, apeland metoda reDraw timp de 60 de secunde
2. Mandelbrot.java - clasa care se ocupa de interfata grafica
                   - genereaza procedural forma graficului Mandelbrot
                   - genereaza aleator culori
                   - asigura rotirea imaginii la fiecare redesenare
3. InputData.java - clasa care se ocupa de citirea datelor din fisierul de intrare
                  - furnizeaza clasei Mandelbrot.java coeficientii pentru generarea multimii mandelbrot
