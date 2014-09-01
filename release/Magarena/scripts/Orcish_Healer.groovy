[
    new MagicPermanentActivation(
        new MagicActivationHints(MagicTiming.Removal),
        "NoRegen"
    ) {
        @Override
        public Iterable<MagicEvent> getCostEvent(final MagicPermanent source) {
		return [new MagicTapEvent(source),
			new MagicPayManaCostEvent(source,"{R}{R}")
		       ];
        }

		@Override
        public MagicEvent getPermanentEvent(final MagicPermanent source, final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                MagicTargetChoice.NEG_TARGET_CREATURE,
                MagicDestroyTargetPicker.DestroyNoRegen,
                this,
                "Target creature\$ can't be regenerated this turn. "
            );
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            event.processTargetPermanent(game, {
                game.doAction(MagicChangeStateAction.Set(
                    it,
                    MagicPermanentState.CannotBeRegenerated
                ));
            });
        }
    }
]
