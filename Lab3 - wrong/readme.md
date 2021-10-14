Readme Laborator 3

- It uses 12) disallow sharing elements. When we add a new element it checks if that element already exists UP or DOWN the hierarchy of elements <br/>

This works however it has its downsides because:<br/>

- I transformed 'Element' from an interface to a 'Class'<br/>
- Everything now inherits the 'Element' class<br/>
- Element is something like a 'god-class' which is an anti-pattern<br/>
- Because everything now inherits 'Element' it creates the problem where 1 'Paragraph' can contain multiple 'Paragraphs' or 1 'SubChapter' can contain multiple 'Books' which is not good