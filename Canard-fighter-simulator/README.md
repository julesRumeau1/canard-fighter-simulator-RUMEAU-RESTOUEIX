1. Quelles classes pourraient être abstraites ?
   - canard pourrait etre abstract car on ne l'instancie jamais
   
2. Quels comportements communs pourraient être définis dans
   une interface ?
   - capacité spéciale est une interface car elle doit forcément etre implementer pour chaque canard

3. Comment représenter un changement de statut (par exemple,
   brûlé ou paralysé) dans la modélisation ?
   - TODO
   
4. Quels seraient les avantages d’utiliser une classe ou une interface supplémentaire pour gérer les capacités spéciales ?
   - facile d’ajouter de nouvelles capacités sans modifier le code existant
   - le code des canards est simplifié, car les capacités sont gérées ailleurs
   - les capacités sont séparées de la logique des canards
   
5. Quels défis sont associés à l’extensibilité de votre modèle pour
   ajouter de nouveaux types de canards ou de nouvelles capacités ?
   - gestion des interaction entre les types
   - gestion gestion des status des canards, un canard pourrat potentiellement cumulé plusieurs status


TODO
- diagramme uml
- description des choix technique