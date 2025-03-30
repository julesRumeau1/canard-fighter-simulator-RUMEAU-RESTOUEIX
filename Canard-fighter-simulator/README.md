Projet Canard Fighter Simulator (**RUMEAU** Jules & **RESTOUEIX** Emilien)

## 4 Questionnements sur la modélisation ##


1. Quelles classes pourraient être abstraites ?
   - canard pourrait etre abstract car on ne l'instancie jamais

   
2. Quels comportements communs pourraient être définis dans
   une interface ?
   - capacité spéciale est une interface car elle doit forcément etre implementer pour chaque canard


3. Comment représenter un changement de statut (par exemple,
   brûlé ou paralysé) dans la modélisation ?
   - Il faudrait rajouter une méthode appliquerStatus qui permettrait de montrer visuellement que l'on change le status d'un canard.
   Puisque dans notre cas on fait directement canard.statut = unStatut.

   
4. Quels seraient les avantages d’utiliser une classe ou une interface supplémentaire pour gérer les capacités spéciales ?
   - facile d’ajouter de nouvelles capacités sans modifier le code existant
   - le code des canards est simplifié, car les capacités sont gérées ailleurs
   - les capacités sont séparées de la logique des canards

   
5. Quels défis sont associés à l’extensibilité de votre modèle pour
   ajouter de nouveaux types de canards ou de nouvelles capacités ?
   - gestion des interaction entre les types
   - gestion gestion des status des canards, un canard pourrat potentiellement cumulé plusieurs status


## 6 Livrables attendus ##

- diagramme uml
![Diagramme UML](/diagramme.png)


- description des choix technique
1. Utilisation de classes abstraites pour les canards
   Nous avons choisi de rendre la classe Canard abstraite car nous ne souhaitons pas l'instancier directement.
   Les différentes sous-classes (par exemple, CanardEau, CanardFeu, etc.) hériteront de cette classe abstraite pour bénéficier des comportements communs,
   tout en permettant une spécialisation propre à chaque type de canard. Cela permet de respecter le principe de polymorphisme.


2. Interfaces pour les capacités spéciales
   Les capacités spéciales sont définies sous forme d'interface pour garantir qu'elles soient implémentées par chaque type de canard.
   Cela offre une flexibilité importante, car chaque canard peut avoir des capacités spéciales différentes,
   mais l'interface assure que chaque canard possède au moins une méthode permettant d'activer sa capacité spéciale.
   Cela découple également la gestion des capacités de la logique propre aux canards.


3. Gestion des statuts des canards avec un Enum Statut
   Le changement de statut d'un canard (par exemple, "brûlé" ou "paralysé") est géré par une énumération (Statut).
   Cela permet de centraliser les différents statuts possibles et d'éviter des chaînes de caractères ou des valeurs magiques dans le code.
   Chaque statut peut ainsi être traité de manière spécifique et les transitions entre statuts peuvent être gérées de manière claire et maintenable.


4. Gestion des interactions entre les types de canards
   Les interactions entre les différents types de canards (par exemple, un CanardEau contre un CanardFeu) sont gérées via une logique de combat,
   où les types de canards et leurs effets spécifiques sont évalués pendant chaque attaque.
   Cela permet d'ajouter facilement de nouvelles interactions ou d'ajuster les forces et faiblesses sans modifier les classes de base des canards.


5. Extensibilité des capacités et des types de canards
   Le système est conçu pour être facilement extensible. Ajouter un nouveau type de canard ou une nouvelle capacité spéciale ne nécessite pas de modifications majeures dans le code existant.
   De nouvelles classes de canards peuvent être créées en étendant Canard et en implémentant les capacités spéciales via l'interface associée.
   De plus, de nouvelles capacités spéciales peuvent être ajoutées sans affecter les autres parties du code.


6. Utilisation d'un Scanner pour l'interaction avec l'utilisateur
   L'interaction avec l'utilisateur se fait via un objet Scanner afin de permettre une saisie dynamique pendant l'exécution du programme.
   Bien que ce soit simple à implémenter pour un jeu en ligne de commande, ce choix pourrait limiter la portabilité du jeu si une interface graphique
   ou un autre moyen d'entrée était nécessaire à l'avenir. Cependant, pour un prototype rapide, cela reste une solution efficace.


7. Le modèle de combat avec des tours
   Chaque combat est organisé autour de tours, où un canard attaque un autre. Ce système est simple à comprendre
   et à implémenter tout en permettant d'ajouter des éléments comme les capacités spéciales et les effets de statut pendant les tours.
   Chaque joueur prend son tour pour décider d'utiliser ou non une capacité spéciale, ce qui introduit une couche de stratégie tout en conservant la fluidité du combat.


8. Modélisation des potions et soins
   Les potions sont gérées par la classe Joueur, qui a un nombre limité de potions. Chaque potion permet de soigner un canard en augmentant ses points de vie,
   ce qui ajoute un élément de gestion des ressources et de stratégie pendant les combats.
   Ce système pourrait être étendu pour inclure différents types de potions ou d'autres objets permettant d'interagir avec le jeu.




-  liste des réalisations bonus :

Partie 5.3 du sujet "Personnalisation et progression"

