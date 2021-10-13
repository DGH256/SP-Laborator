Readme Laborator 3

This works however it is wrong because:<br/>

-I transformed 'Element' from an interface to a 'Class'<br/>
-Everything now inherits the 'Element' class<br/>
-Element is now a 'god-class' which is an anti-pattern<br/>
-Because everything now inherits 'Element' it creates the problem where 1 'Paragraph' can contain multiple 'Paragraphs' or 1 'SubChapter' can contain multiple 'Books' which is not good