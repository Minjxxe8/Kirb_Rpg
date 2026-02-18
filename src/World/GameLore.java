package World;

public class GameLore {

    public String getIntroduction() {
        return """
                
                ╔════════════════════════════════════════════════════════╗
                ║           BIENVENUE DANS KIRBY RPG GAME !              ║
                ╚════════════════════════════════════════════════════════╝
                
                Dans un monde coloré de Dream Land, une menace obscure
                s'est emparée des 5 royaumes magiques...
                
                Kirby, notre héros, doit voyager à
                travers ces mondes pour restaurer la paix et vaincre
                les forces du mal qui menacent son univers !
                
                En absorbant ses ennemis, Kirby peut acquérir leurs
                pouvoirs uniques. Collectionne de l'or, améliore tes
                capacités et sauve Dream Land !
                
                ════════════════════════════════════════════════════════
                """;
    }

    public String getWorldLore(int worldNumber) {
        return switch (worldNumber) {
            case 1 -> """
                    
                    ╔════════════════════════════════════════════════════════╗
                    ║              MONDE 1 : LA FORÊT VERTE                  ║
                    ╚════════════════════════════════════════════════════════╝
                    
                    Tu arrives dans la Forêt Verte, un lieu autrefois paisible
                    désormais infesté de créatures hostiles. Les arbres anciens
                    murmurent des secrets oubliés...
                    
                    C'est ici que ton aventure commence !
                    """;
            case 2 -> """
                    
                    ╔════════════════════════════════════════════════════════╗
                    ║            MONDE 2 : LES CAVERNES DE FEU               ║
                    ╚════════════════════════════════════════════════════════╝
                    
                    La chaleur intense te frappe dès ton arrivée. Les Cavernes
                    de Feu abritent des créatures enflammées et des volcans
                    menaçants. Fais attention à ne pas te brûler !
                    
                    La température monte... tout comme le danger !
                    """;
            case 3 -> """
                    
                    ╔════════════════════════════════════════════════════════╗
                    ║            MONDE 3 : LES RUINES ANCIENNES              ║
                    ╚════════════════════════════════════════════════════════╝
                    
                    Des structures mystérieuses émergent du sable. Les Ruines
                    Anciennes renferment des énigmes millénaires et des
                    gardiens qui protègent leurs secrets.
                    
                    Le passé refait surface...
                    """;
            case 4 -> """
                    
                    ╔════════════════════════════════════════════════════════╗
                    ║            MONDE 4 : LE ROYAUME GELÉ                   ║
                    ╚════════════════════════════════════════════════════════╝
                    
                    Un vent glacial te saisit. Le Royaume Gelé est recouvert
                    de neige éternelle. Ses habitants de glace ne te feront
                    aucun cadeau !
                    
                    Prépare-toi à affronter le froid mordant !
                    """;
            case 5 -> """
                    
                    ╔════════════════════════════════════════════════════════╗
                    ║          MONDE 5 : LA FORTERESSE DES TÉNÈBRES          ║
                    ╚════════════════════════════════════════════════════════╝
                    
                    Tu arrives enfin au cœur des ténèbres. La Forteresse du
                    Mal se dresse devant toi, imposante et menaçante. C'est
                    ici que tout se terminera...
                    
                    Le combat final t'attend !
                    """;
            default -> "";
        };
    }
}
