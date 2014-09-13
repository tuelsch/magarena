def TWO_ISLANDS_CONDITION = new MagicCondition() {
    public boolean accept(final MagicSource source) {
        return source.getController().getNrOfPermanents(MagicSubType.Island) >= 2;
    }
};

def choice = new MagicTargetChoice("an Island you control");
[
     new MagicCardActivation(
        [TWO_ISLANDS_CONDITION, MagicCondition.CARD_CONDITION],
        new MagicActivationHints(MagicTiming.Tapping),
        "NoCost"
    ) {

        @Override
        public Iterable<MagicEvent> getCostEvent(final MagicCard source) {
            return [ 
            new MagicBounceChosenPermanentEvent(source,choice),
            new MagicBounceChosenPermanentEvent(source,choice)
            ];
        }
    }
]
