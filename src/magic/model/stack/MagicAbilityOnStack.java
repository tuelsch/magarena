package magic.model.stack;

import magic.data.IconImages;
import magic.model.MagicCopyMap;
import magic.model.MagicPayedCost;
import magic.model.MagicPermanent;
import magic.model.event.MagicPermanentActivation;

import javax.swing.ImageIcon;

public class MagicAbilityOnStack extends MagicItemOnStack {
        
    public MagicAbilityOnStack(
            final MagicPermanentActivation activation,
            final MagicPermanent permanent,
            final MagicPayedCost payedCost) {
        super(permanent, permanent.getController(), activation.getPermanentEvent(permanent,payedCost), activation);
    }
    
    private MagicAbilityOnStack(final MagicCopyMap copyMap, final MagicAbilityOnStack source) {
        super(copyMap, source);
    }

    @Override
    public MagicAbilityOnStack copy(final MagicCopyMap copyMap) {
        return new MagicAbilityOnStack(copyMap, this);
    }

    @Override
    public boolean isSpell() {
        return false;
    }

    @Override
    public boolean canBeCountered() {
        return true;
    }
        
    @Override
    public ImageIcon getIcon() {
        return IconImages.ABILITY;
    }    
}
