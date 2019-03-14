# Aufgabe 'Nested - Predicate - Personen'

- Jede Person hat Vornamen, Nachnamen und Geburtsjahr


- Erzeugen Sie in der main-Methode einer Test-Klasse mindestens 4 Personen und speichern sie in einem Array


- Definieren Sie in der Test-Klasse eine weitere Methode:
   
        List<Person> filtern(Person[], Predicate<Person>)
   
Sie liefert eine `java.util.List` zurück, in dem nur die Personen gespeichert sind, die mit dem übergebenem Predicate (2. Parameter) akzeptiert werden. Die Methode sucht in dem Array, das als 1. Parameter übergeben wird.


- Erzeugen Sie mit einer Toplevel-Klasse einen Predicate-Filter, der nur die Personen akzeptiert, die nach einem bestimmten Jahr geboren wurden. Testen Sie den Filter mit der Methode `filtern`.


- Erzeugen Sie mit einer inneren Klasse einen Predicate-Filter, der nur die Personen akzeptiert, die in ihrem Nachnamen mindestens ein 'a' haben. Testen Sie den Filter mit der Methode `filtern`.


- Erzeugen Sie mit einer lokalen Klasse einen Predicate-Filter, der nur die Personen akzeptiert, die in ihrem Nachnamen mindestens 4 Zeichen haben. Testen Sie den Filter mit der Methode `filtern`.

   
- Erzeugen Sie mit einer anonymen Klasse einen Predicate-Filter, der die Eigenschaften zwei anderer Filter (im weiteren A und B genannt) vereint. Akzeptiert werden mit dem neuen Filter nur die Personen, die von Filter A UND Filter B akzeptiert werden. Benutzen Sie zum Testen als Filter A und B die Filter aus den bisherigen Aufgabenpunkten. Testen Sie den neuen Predicate-Filter mit der Methode `filtern`.


- Optional: Rufen Sie die Methode filtern mit einer Lambda-Funktion auf, mit der nur die Personen akzeptiert werden, die in einem Schaltjahr geboren wurden.
