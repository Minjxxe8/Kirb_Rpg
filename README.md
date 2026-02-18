# Kirby RPG

Jeu RPG en Java sur terminal, inspiré de Kirby.

## Fonctionnalités

- Progression sur 5 mondes avec combats
- Monstres aléatoires + boss de fin de monde
- Inventaire avec potions et or
- Boutique entre les mondes (achat de potion/pouvoir)
- Pouvoirs spéciaux Kirby (avec variantes)
- Interface terminal ameliorée (titres, couleurs ANSI, barres de vie)
- Règle gameplay: Kirby ne peut aspirer un pouvoir qu'une fois par monde

## Lancer le jeu

### Option 1 - IntelliJ (recommande)

1. Ouvrir le projet
2. Configurer le SDK sur Java 21
3. Activer les preview features Java 21 dans la configuration de run
4. Lancer `src/Main.java`

### Option 2 - Terminal (compilation)

Compilation:

```bash
javac --enable-preview --release 21 -d out src/Main.java src/Core/*.java src/World/*.java src/Powers/*.java
```

Note: l'entrée principale actuelle est basée sur preview Java (`void main()`), donc le lancement direct est plus simple via IntelliJ.

## Structure du projet

- `src/Main.java` : point d'entrée
- `src/Core/` : entités, combat, inventaire, factories
- `src/Powers/` : système de pouvoirs et decorators
- `src/World/` : boucle de jeu, lore, boutique, items

## Patterns utilisés

- Strategy: attaques du boss (`AttackStrategy`, `FastAttack`, `HeavyAttack`)
- Factory: création des monstres/pouvoirs (`MonsterFactory`, `PowerFactory`)
- Decorator: amélioration de pouvoirs (`EnhancedPower`, `PowerDecorator`)

## Notes

Les couleurs terminal utilisent ANSI. Le jeu reste jouable sans, mais il est moins lisible.

## Auteures du projet

Léna Ricard - Elisabeth Robl - Emma De Oliveira