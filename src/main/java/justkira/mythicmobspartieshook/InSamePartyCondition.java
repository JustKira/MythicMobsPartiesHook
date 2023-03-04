package justkira.mythicmobspartieshook;

import com.alessiodp.parties.api.Parties;
import com.alessiodp.parties.api.interfaces.PartiesAPI;
import com.alessiodp.parties.api.interfaces.Party;
import com.alessiodp.parties.api.interfaces.PartyPlayer;
import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.conditions.IEntityComparisonCondition;

public class InSamePartyCondition implements IEntityComparisonCondition {

    public InSamePartyCondition(MythicLineConfig config) {

    }

    @Override
    public boolean check(AbstractEntity caster, AbstractEntity target) {

        if (!target.isPlayer()) {
            return false;
        }
        PartiesAPI api = Parties.getApi();

        PartyPlayer casterPlayer = api.getPartyPlayer(caster.getUniqueId());
        PartyPlayer targetPlayer = api.getPartyPlayer(target.getUniqueId());

        if (!targetPlayer.isInParty()) {
            return false;
        }
        if(targetPlayer.isInParty() && casterPlayer.isInParty()) {
            Party casterPartyId = api.getParty(casterPlayer.getPartyId());
            Party targetPartyId = api.getParty(targetPlayer.getPartyId());

            if(casterPartyId == targetPartyId) {
                return true;

            }else
            {
                return false;
            }
        }
        //PartiesApi api = Parties.getApi();
        return false;
    }
}