# LOG320-02_team_201_lab2
# Jeu de plateau
# Jeu de « Breakthrough»
Durée : 6 semaines
## Introduction
Le jeu de « Breakthrough » est un jeu à deux joueurs qui se joue sur un plateau de 8X8. La simplicité des règles a
permis à ce jeu de gagner la compétition "8x8 Game Design Competition" en 2001. Malgré cette simplicité, la
maîtrise de ce jeu demande l'élaboration d'une stratégie évoluée et à long terme. De plus, les règles du jeu font en
sorte qu'il est mathématiquement impossible d'avoir un match nul.
Les objectifs de ce laboratoire sont :
• Implémentation de l’algorithme minimax et alpha-beta
• Implémentation d’heuristiques pour le jeu de Breakthrough
• Exploration et implémentation de différentes stratégies afin d’améliorer l’efficacité de votre algorithme de
décision.
Règles du jeu
## Configuration du plateau
Le jeu de « Breakthrough » se joue sur un plateau standard de 8x8. Chaque joueur dispose de 16 jetons. Les jetons
dur joueur noir sont placés sur les deux dernières lignes du plateau tandis que les jetons du joueur rouge sont placés
sur les deux premières rangées. La figure 1 montre la configuration initiale du jeu.
Les joueurs doivent jouer une pièce à tour de rôle. Les rouges sont toujours les premiers à jouer.
## But du jeu
Le gagnant est le premier joueur qui arrive à positionner un de ses pions dans la zone adverse, c'est-à-dire sur la
rangée 8 pour les rouges et sur la rangée 1 pour les noirs.
## Déplacements
																		
Les déplacements sont vraiment très simples. Les jetons peuvent être déplacés que d'une seule case à la fois et
toujours en direction de la zone adverse. Il n’est donc pas possible pour une pièce de revenir en arrière. Pour un
déplacement vers une case vide, il y a trois directions possibles : diagonale à droite, directement en avant et
diagonale à gauche. Le jeu permet aussi la capture de jetons adverses mais seulement lors des déplacements en
diagonale.
La figure 2 montre des exemples de mouvements possibles pour un jetons.
Figure 2 : (a) Lorsqu’il n’y a pas de capture impliquée, la pièce peut être
déplace d’une case vers l’avant pour vers une des deux diagonales (b) Les
captures se font uniquement via les déplacements en diagonale.
## Autres règles et consignes
Votre programme devra vérifier la validité du coup entrée par l’adversaire. De plus, votre programme aura un
maximum de 5 secondes à chaque tour pour jouer son coup. Votre programme devra offrir la possibilité au joueur de
jouer les rouges ou les noirs (en option sur la ligne de commande ou en posant la question au début de la partie).
Interface
Une interface graphique de type serveur est disponible sur le site du cours. Il est cependant recommandé d’avoir une
interface console minimale afin de pouvoir suivre le déroulement du jeu sur la console. Cette interface pourrait être
pratique pour le "debugage" de votre application.
La communication avec le serveur est plutôt simple. Au départ, le serveur vous envoie le message "1" avec la
configuration du plateau de départ si vous êtes les rouges. La commande sera le "2" suivit de la configuration du
plateau si vous êtes les noirs. Voici un exemple de message (message 1 avec la configuration du plateau) :
1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 0 0 0 ... 0 0 0 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4
Les différentes pièces sont représentées par des chiffres :
### Numéro Pièce
0 Case vide
2 Pion noir
4 Pion rouge

Lorsque c’est le tour à votre programme de jouer son coup, le serveur vous envoie le message "3" ainsi que le dernier
coup jouer par l’adversaire. Voici un exemple de message :
D6-D8
Si votre joueur est rouge, vous devez donc jouer le premier. Dans ce cas particulier, le message va contenir un coup
invalide :
A8-A8
Dans l’éventualité où le coup transmis serait invalide (cela ne devrait jamais se produire), le message "4" sera envoyé
par le serveur qui restera en attente d’un nouveau coup.
Spécification d’un coup
Un mouvement est composé de la case de départ et de la case cible. Le serveur supporte deux formats pour
transmettre le coup à jouer :
D6-D5
ou
D6D5
Un programme de démonstration, en Java, est disponible sur le site du cours.
## Fonctions à implémenter
Voici les fonctions qui doivent minimalement être implémentées afin d’avoir un joueur artificiel :
Générateur de mouvements :
Cette fonction utilise la configuration du plateau pour générer tous les coups possibles. Tous les coups de
cette liste doivent être valident.
## Fonction d’évaluation :
Cette fonction a pour but d’évaluer la position sur le plateau. Plus l’évaluation est bonne, plus votre
programme sera bon. C’est aussi cette fonction qui détermine si un joueur a gagné.
Algorithme MinMax et AlphaBeta :
Fonction qui détermine le prochain coup de l’ordinateur. Je vous rappelle que cette fonction dispose de 5
secondes pour choisir son coup.

## Vérification du programme
Une première vérification sera effectuée à la 4ième semaine du laboratoire. À ce moment, vous devrez démontrer le
fonctionnement de votre programme. À ce point, vous devez avoir implémenté :
• L’algorithme minmax
• L’élagage alpha-beta
• Une fonction d’évaluation statique de base
À la 5ième semaine du laboratoire, un deuxième point contrôle sera effectué. À ce moment, il sera vérifié si votre
programme peut battre le niveau 1 (en tant que joueur rouge et noir).
À la dernière séance de laboratoire, un tournoi est organisé. Votre programme sera évalué en fonction de votre
performance dans le tournoi, mais aussi en fonction des performances contre le programme de démonstration.
Noter que pour compléter la grille du tournoi, le programme de démonstration, au niveau 2, peut-être ajouté à la
compétition.
Rapport de laboratoire
Les modalités du rapport de laboratoire vous seront spécifiées par le chargé de laboratoire vers la fin de la session.
## Barème de correction
Le barème de correction est le suivant :
Pour obtenir tous vos points dans les évaluations contre le serveur, vous devez le battre en tant que joueur rouge et en
tant que joueur noir.
Noter que les points bonus ne permettent pas de dépasser le 15/15.
Le barème concernant les points de performance sera expliqué par le responsable du laboratoire.
Tic tac toe 3
Point de contrôle 1 1
Point de contrôle 2 (niveau 1) 2
Battre le serveur au niveau 2 2
Battre le serveur au niveau 3 (bonus) (2)
Performance dans le tournoi 4
Rapport de laboratoire 3
Total 15
