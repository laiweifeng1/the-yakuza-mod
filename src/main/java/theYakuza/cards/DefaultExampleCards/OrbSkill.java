package theYakuza.cards.DefaultExampleCards;

import basemod.abstracts.CustomCard;
import theYakuza.YakuzaMod;
import theYakuza.cards.AbstractDynamicCard;
import theYakuza.characters.TheYakuza;
import theYakuza.orbs.DefaultOrb;

import static theYakuza.YakuzaMod.makeCardPath;

import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.AutoAdd;

@AutoAdd.Ignore
public class OrbSkill extends AbstractDynamicCard {

    /*
     * Orb time.
     *
     * Channel 1 Default Orb.
     */

    // TEXT DECLARATION

    public static final String ID = YakuzaMod.makeID(OrbSkill.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Skill.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    // /TEXT DECLARATION/

    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheYakuza.Enums.COLOR_YAKUZA;

    private static final int COST = 1;

    // /STAT DECLARATION/

    public OrbSkill() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        AbstractDungeon.actionManager.addToBottom(new ChannelAction(new DefaultOrb())); // Channel a Default Orb.

    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.initializeDescription();
        }
    }
}