[
    MagicWhenComesIntoPlayTrigger.PutGolemOntoTheBattlefield,
    new MagicPermanentActivation(
        [
            MagicConditionFactory.ManaCost("{1}"),
            MagicCondition.CONTROL_GOLEM_CONDITION
        ],
        new MagicActivationHints(MagicTiming.Pump,true),
        "Regen"
    ) {

        @Override
        public MagicEvent[] getCostEvent(final MagicPermanent source) {
            return [new MagicPayManaCostEvent(source,"{1}")];
        }

        @Override
        public MagicEvent getPermanentEvent(final MagicPermanent source,final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                MagicTargetChoice.POS_TARGET_GOLEM_YOU_CONTROL,
                MagicRegenerateTargetPicker.getInstance(),
                this,
                "Regenerate target Golem\$ you control."
            );
        }

        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            event.processTargetPermanent(game,new MagicPermanentAction() {
                public void doAction(final MagicPermanent creature) {
                    game.doAction(new MagicRegenerateAction(creature));
                }
            });
        }
    }
]
