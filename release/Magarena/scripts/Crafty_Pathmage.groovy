[
    new MagicPermanentActivation(
        [MagicCondition.CAN_TAP_CONDITION],
        new MagicActivationHints(MagicTiming.Attack),
        "Unblockable"
    ) {

        @Override
        public MagicEvent[] getCostEvent(final MagicPermanent source) {
            return [new MagicTapEvent(source)];
        }

        @Override
        public MagicEvent getPermanentEvent(final MagicPermanent source,final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                MagicTargetChoice.TARGET_CREATURE_POWER_2_OR_LESS,
                MagicUnblockableTargetPicker.create(),
                this,
                "Target creature\$ with power 2 or less is unblockable this turn."
            );
        }

        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            event.processTargetPermanent(game,new MagicPermanentAction() {
                public void doAction(final MagicPermanent creature) {
                    game.doAction(new MagicSetAbilityAction(creature,MagicAbility.Unblockable));
                }
            });
        }    
    }
]
