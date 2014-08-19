[
    new MagicAtYourUpkeepTrigger() {
        @Override
        public MagicEvent executeTrigger(final MagicGame game,final MagicPermanent permanent,final MagicPlayer player) {
            return new MagicEvent(
                permanent,
                this,
                "SN deals 1 damage to each player."
            );
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            final MagicSource source=event.getSource();
            for (final MagicPlayer player : game.getAPNAP()) {
                final MagicDamage damage=new MagicDamage(source,player,1);
                game.doAction(new MagicDealDamageAction(damage));
            }
        }
    }
]
