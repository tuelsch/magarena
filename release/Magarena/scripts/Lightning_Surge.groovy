[
    new MagicSpellCardEvent() {
        @Override
        public MagicEvent getEvent(final MagicCardOnStack cardOnStack,final MagicPayedCost payedCost) {
            return new MagicEvent(
                cardOnStack,
                MagicTargetChoice.TARGET_CREATURE_OR_PLAYER,
                this,
                "SN deals 4 damage to target creature or player. " +
                "If seven or more cards are in your graveyard, SN deals 6 damage to that creature or player and the damage can't be prevented."
            );
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            event.processTarget(game, {
            if (MagicCondition.THRESHOLD_CONDITION.accept(event.getSource())) {
                final MagicDamage damage = new MagicDamage(event.getSource(),it,6);
                damage.setUnpreventable();
                game.doAction(new MagicDealDamageAction(damage));
            } else {
                final MagicDamage damage2 = new MagicDamage(event.getSource(),it,4);
                game.doAction(new MagicDealDamageAction(damage2));
            }
            });
        }
    }
]
