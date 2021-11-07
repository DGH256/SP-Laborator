Feedback primit pentru prima tema (https://github.com/DorinGalben/SP-Laborator/tree/main/Lab5%20-%20homework) :
1) Image.print nu e ce trebuie. Are responsabilitiati multiple: a) incarca imaginea din fisier, b)  creaza un icon, c) creaza contextul de randar (JPanel-ul). Responsaibilitatea ei ar trebui sa redea o imagine intr-un context de randare pe care il primeste 'de la client' (adica apelant). Incarcarea imaginii din fiser ar trebui facuta in clasele ce implementeaza ImageLoader (BMPImageLoader, JPGImageLoader etc) chiar daca pentru anumite tipuri de fisiere implementarea va fi aceeasi ImageIO.read(...). In constructorul clasei Image ar trebui incarcat continutul imaginii, adica  this.imageContent = imageFactory.create(url).content()
2) De ce ai nevoie de metoda clone()?
3) Image.add cu un body empty si un comment // not needed , arata ca ceva ce ar putea fi imbunatatit la cursul de sabloane de proiectare
4) AlignStrategy --- nu e implementata niciuna
6) Lab5 - homework.iml nu are ce cauta pe git

Schimbari facute la aceasta tema :

2) Am sters metoda clone() din interfata Element si alte clase. Ea ramasese din laboratorul 3, cerinta 11 unde trebuia sa adaugam o clona a elementului cu metoda add().
5) Nu am mai pus fisierele .iml pe git.
3) Image.add cu un body empty -- intr-adevar este o greseala. M-am uitat din nou peste diagrama laboratorului si am vazut ca Image nu trebuie sa implementeze Element, numai ImageProxy trebuie. Image nu mai implementeaza Element acum dar ImageProxy tot trebuie sa implementeze iar ImageProxy va avea in continuare metodele add(), remove(), find() cu body empty.
4) AlignStrategy am implementat acum. Am pus Context drept lungimea String-ului ce trebuie afisat de AlignStrategy, cu offset in functie de tipul alininierii.
Exemplu : AlignLeft: Paragraph1----, AlignCenter: --Paragraph1--, AlignRight: ----Paragraph1. In interiorul paragraph este apelat "strategy.render(this,new Context(100));".
1) -Am mutat incarcarea imaginilor din fisier in BMPImageLoader, PNGImageLoader, JPGImageLoader. O problema este ca "ImageIO.read" poate arunca "IOException" deci acum am foarte multe metode cu "throws IOException";
   -In constructorul clasei Image este incarcat acum continutul imaginii, this.imageLoader = imageFactory.create(url);
   -In clasa Image am acum 2 metode print, o metoda print(PrintStream) -- unde primeste 'de la client' un Printstream si afiseaza numele+dimensiunea imagini.
    O alta  metoda print(Jpanel panel, JLabel label, JFrame frame) -- unde primeste 'de la client' elementele JPanel,label,frame unde este redata imaginea. In interiorul ImageProxy sunt creeate un JPanel,JLabel,Jframe iar apoi ele sunt predate metodei 'print' a Imaginii. 
   Cred ca si aceasta implementare este gresita pentru ca in interiorul metodei print(JPanel,JLabel,JFrame) apelam new JLabel(), new JFrame(), new new JPanel() dar sunt nevoie sa le apelez pentru a desena imaginea imaginea deci nu stiu sigur cum sa rezolv corect cerinta.
   
   
 ![Screenshot_5780](https://user-images.githubusercontent.com/91731551/140642785-ad0f8122-2f36-4b26-b2c0-0c94f8d262a6.png)
