package magic.model.trigger;

import magic.model.MagicPermanent;

public abstract class ThisBlocksOrBecomesBlockedTrigger extends BlocksTrigger {
    public ThisBlocksOrBecomesBlockedTrigger(final int priority) {
        super(priority);
    }

    public ThisBlocksOrBecomesBlockedTrigger() {}

    @Override
    public boolean accept(final MagicPermanent permanent, final MagicPermanent blocker) {
        final MagicPermanent blocked = blocker.getBlockedCreature();
        return permanent == blocked || (permanent == blocker && blocked.isValid());
    }

    @Override
    public MagicTriggerType getType() {
        return MagicTriggerType.WhenBlocks;
    }
}
