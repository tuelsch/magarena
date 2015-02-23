def EFFECT1 = MagicRuleEventAction.create("You gain 5 life.");

def EFFECT2 = MagicRuleEventAction.create("Counter target spell.");

def EFFECT3 = MagicRuleEventAction.create("Target creature gets -2/-2 until end of turn.");

[
    new MagicSpellCardEvent() {
        @Override
        public MagicEvent getEvent(final MagicCardOnStack cardOnStack, final MagicPayedCost payedCost) {
            return new MagicEvent(
                cardOnStack,
                new MagicOrChoice(
                    MagicTargetChoice.NONE,
                    MagicTargetChoice.NEG_TARGET_SPELL,
                    MagicTargetChoice.NEG_TARGET_CREATURE
                ),
                this,
                "Choose one\$ - you gain 5 life; " +
                "or counter target spell; " +
                "or target creature gets -2/-2 until end of turn.\$" 
            );
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            event.executeModalEvent(game, EFFECT1, EFFECT2, EFFECT3);
        }
    }
]
