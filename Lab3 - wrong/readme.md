This works however it is wrong because:

-I transformed 'Element' from an interface to a 'Class'
-Everything now inherits the 'Element' class
-Element is now a 'god-class' which is an anti-pattern
-Because everything now inherits 'Element' it creates the problem
where 1 'Paragraph' can contain multiple 'Paragraphs' or 1 'SubChapter' can contain multiple 'Books'