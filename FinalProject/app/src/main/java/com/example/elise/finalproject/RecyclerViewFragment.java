package com.example.elise.finalproject;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerMonsters;

    public RecyclerViewFragment(){
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Decides layout the fragment will use
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    //View passed in contains all of the XML views
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //Map the view
        recyclerMonsters = (RecyclerView) view.findViewById(R.id.recycler_monsters);

        //Creating a LayoutManager for the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        //Setting the LayoutManager to the RecyclerView
        recyclerMonsters.setLayoutManager(layoutManager);

        //Creating a list of monsters
        List<Monster> monsters = monsters();

        Context context = this.getActivity();
        SharedPreferences preferences = context.getSharedPreferences("prefs",Context.MODE_PRIVATE);

        //Setting the adapter
        recyclerMonsters.setAdapter(new MonsterAdapter(monsters,getActivity().getApplicationContext()));

    }

    private List<Monster> monsters() {
        //Creating list of monsters and filling with data
        List<Monster> monsters = new ArrayList<>();

        ArrayList<String> actions1 = new ArrayList<String>();
        actions1.add(new String("Fist. Melee Weapon Attack: +5 to hit, reach 5 ft., one target. Hit: 6 (1d6 + 3) bludgeoning damage."));
        actions1.add(new String("Rock. Ranged Weapon Attack: +5 to hit, range 25/50 ft., one target. Hit: 6 (1d6 + 3) bludgeoning damage."));
        actions1.add(new String("Multiattack. The ape makes two fist attacks."));
        ArrayList<String> special1 = new ArrayList<String>();
        special1.add(new String("-"));

        ArrayList<String> actions2 = new ArrayList<String>();
        actions2.add(new String("Bite. Melee Weapon Attack: +3 to hit, reach 5 ft., one target. Hit: 4 (1d6 + 1) piercing damage."));
        actions2.add(new String("Teleport (Recharge 4-6). The dog magically teleports, along with any equipment it is wearing or carrying, up to 40 feet to an unoccupied space it can see. Before or after teleporting, the dog can make one bite attack."));
        ArrayList<String> special2 = new ArrayList<String>();
        special2.add(new String("Keen Hearing and Smell. The dog has advantage on Wisdom (Perception) checks that rely on hearing or smell."));

        ArrayList<String> actions3 = new ArrayList<String>();
        actions3.add(new String("Tusk. Melee Weapon Attack: +3 to hit, reach 5 ft., one target. Hit: 4 (ld6 + 1) slashing damage."));
        ArrayList<String> special3 = new ArrayList<String>();
        special3.add(new String("Charge. If the boar moves at least 20 feet straight toward a target and then hits it with a tusk attack on the same turn, the target takes an extra 3 (1 d6) slashing damage. If the target is a creature, it must succeed on a DC 11 Strength saving throw or be knocked prone."));
        special3.add(new String("Relentless (Recharges after a Short or Long Rest). If the boar takes 7 damage or less that would reduce it to 0 hit points, it is reduced to 1 hit point instead."));

        ArrayList<String> actions4 = new ArrayList<String>();
        actions4.add(new String("Bite. Melee Weapon Attack: +4 to hit, reach 5 ft., one creature. Hit: 7 (1d10 + 2) piercing damage, and the target must make a DC 11 Constitution saving throw, taking 18 (4d8) poison damage on a failed save, or half as much damage on a successful one. If the poison damage reduces the target to 0 hit points, the target is stable but poisoned for 1 hour, even after regaining hit points, and is paralyzed while poisoned in this way."));
        ArrayList<String> special4 = new ArrayList<String>();
        special4.add(new String("Ethereal jaunt. As a bonus action, the spider can magically shift from the Material Plane to the Ethereal Plane, or vice versa."));
        special4.add(new String("Spider Climb. The spider can climb difficult surfaces, including upside down on ceilings, without needing to make an ability check."));
        special4.add(new String("Web Walker. The spider ignores movement restrictions caused by webbing."));

        ArrayList<String> actions5 = new ArrayList<String>();
        actions5.add(new String("Bite. Melee Weapon Attack: +5 to hit, reach 5 ft. , one target. Hit: 1 piercing damage."));
        ArrayList<String> special5 = new ArrayList<String>();
        special5.add(new String("Blood Frenzy. The quipper has advantage on melee attack rolls against any creature that doesn't have all its hit points."));
        special5.add(new String("Water Breathing. The quipper can breathe only underwater."));

        ArrayList<String> actions6 = new ArrayList<String>();
        actions6.add(new String("Scimitar. Melee Weapon Attack: +3 to hit, reach 5 ft., one target. Hit: 4 (1d6 + 1) slashing damage."));
        actions6.add(new String("Light Crossbow. Ranged Weapon Attack: +3 to hit, range 80 ft./320ft., one target. Hit: 5 (1d8 + 1) piercing damage."));
        ArrayList<String> special6 = new ArrayList<String>();
        special6.add(new String("-"));

        ArrayList<String> actions7 = new ArrayList<String>();
        actions7.add(new String("Multiattack. The owl bear makes two attacks: one with its beak and one with its claws."));
        actions7.add(new String("Beak. Melee Weapon Attack: +7 to hit, reach 5 ft., one creature. Hit: 10 (1d10 + 5) piercing damage."));
        actions7.add(new String("Claws. Melee Weapon Attack: +7 to hit, reach 5 ft., one target. Hit: 14 (2d8 + 5) slashing damage."));
        ArrayList<String> special7 = new ArrayList<String>();
        special7.add(new String("Keen Sight and Smell. The owl bear has advantage on Wisdom (Perception) checks that rely on sight or smell."));

        ArrayList<String> actions8 = new ArrayList<String>();
        actions8.add(new String("Club. Melee Weapon Attack: +2 to hit, reach 5 ft., one target. Hit: 2 (1d4) bludgeoning damage."));
        ArrayList<String> special8 = new ArrayList<String>();
        special8.add(new String("-"));

        ArrayList<String> actions9 = new ArrayList<String>();
        actions9.add(new String("Claw. Melee Weapon Attack: +3 to hit, reach 5 ft., one target. Hit: 3 (1d4 + 1) bludgeoning or slashing damage (claw's choice)."));
        ArrayList<String> special9 = new ArrayList<String>();
        special9.add(new String("Turn Immunity. The claw is immune to effects that turn undead."));

        ArrayList<String> actions10 = new ArrayList<String>();
        actions10.add(new String("Slam. Melee Weapon Attack: +3 to hit, reach 5 ft., one target. Hit: 4 (1d6 + 1) bludgeoning damage."));
        ArrayList<String> special10 = new ArrayList<String>();
        special10.add(new String("Undead Fortitude. If damage reduces the zombie to 0 hit points, it must make a Constitution saving throw with a DC of 5 +the damage taken, unless the damage is radiant or from a critical hit. On a success, the zombie drops to 1 hit point instead."));

        ArrayList<String> actions11 = new ArrayList<String>();
        actions11.add(new String("Multiattack. The tarrasque can use its Frightful Presence. It then makes five attacks: one with its bite, two with its claws, one with its horns, and one with its tail. It can use its Swallow instead of its bite."));
        actions11.add(new String("Bite. Melee Weapon Attack: +19 to hit, reach 10 ft., one target. Hit: 36 (4d1 2 + 10) piercing damage. If the target is a creature, it is grappled (escape DC 20). Until this grapple ends, the target is restrained, and the tarrasque can't bite another target."));
        actions11.add(new String("Claw. Melee Weapon Attack: +19 to hit, reach 15 ft., one target. Hit: 28 (4d8 + 10) slashing damage."));
        actions11.add(new String("Horns. Melee Weapon Attack: +19 to hit, reach 10 ft., one target. Hit: 32 (4d10 + 10) piercing damage."));
        actions11.add(new String("Tail. Melee Weapon Attack: +19 to hit, reach 20 ft., one target. Hit: 24 (4d6 + 1 0) bludgeoning damage. If the target is a creature, it must succeed on a DC 20 Strength saving throw or be knocked prone."));
        actions11.add(new String("Frightful Presence. Each creature of the tarrasque's choice within 120 feet of it and aware of it must succeed on a DC 17 Wisdom saving throw or become frightened for 1 minute. A creature can repeat the saving throw at the end of each of its turns, with disadvantage if the tarrasque is within line of sight, ending the effect on itself on a success. If a creature's saving throw is successful or the effect ends for it, the creature is immune to the tarrasque's Frightful Presence for the next 24 hours."));
        actions11.add(new String("Swallow. The tarrasque makes one bite attack against a Large or smaller creature it is grappling. If the attack hits, the target takes the bite's damage, the target is swallowed, and the grapple ends. While swallowed, the creature is blinded and restrained, it has total cover against attacks and other effects outside the tarrasque, and it takes 56 (l6d6) acid damage at the start of each of the tarrasque's turns. If the tarrasque takes 60 damage or more on a single turn from a creature inside it, the tarrasque must succeed on a DC 20 Constitution saving throw at the end of that turn or regurgitate all swallowed creatures, which fall prone in a space within 10 feet of the tarrasque. If the tarrasque dies, a swallowed creature is no longer restrained by it and can escape from the corpse by using 30 feet of movement, exiting prone."));
        ArrayList<String> special11 = new ArrayList<String>();
        special11.add(new String("Legendary Resistance (3/Day). If the tarrasque fails a saving throw, it can choose to succeed instead."));
        special11.add(new String("Magic Resistance. The tarrasque has advantage on saving throws against spells and other magical effects."));
        special11.add(new String("Reflective Carapace. Any time the tarrasque is targeted by a magic missile spell, a line spell, or a spell that requires a ranged attack roll, roll a d6. On a 1 to 5, the tarrasque is unaffected. On a 6, the tarrasque is unaffected, and the effect is reflected back at the caster as though it originated from the tarrasque, turning the caster into the target."));
        special11.add(new String("Siege Monster. The tarrasque deals double damage to objects and structures."));

        ArrayList<String> actions12 = new ArrayList<String>();
        actions12.add(new String("Multiattack. The dragon turtle makes three attacks: one with its bite and two with its claws. It can make one tail attack in place of its two claw attacks."));
        actions12.add(new String("Bite. Melee Weapon Attack: +12 to hit, reach 15 ft., one target. Hit: 26 (3d12 + 7) piercing damage."));
        actions12.add(new String("Claw. Melee Weapon Attack: +12 to hit, reach 10 ft., one target. Hit: 16 (2d8 + 7) slashing damage."));
        actions12.add(new String("Tail. Melee Weapon Attack: +12 to hit, reach 15 ft., one target. Hit: 26 (3d12 + 7) bludgeoning damage. If the target is a creature, it must succeed on a DC 20 Strength saving throw or be pushed up to 10 feet away from the dragon turtle and knocked prone."));
        actions12.add(new String("Steam Breath (Recharge 5-6). The dragon turtle exhales scalding steam in a 60-foot cone. Each creature in that area must make a DC 18 Constitution saving throw, taking 52 (1Sd6) fire damage on a failed save, or half as much damage on a successful one. Being underwater doesn't grant resistance against this damage."));
        ArrayList<String> special12 = new ArrayList<String>();
        special12.add(new String("Amphibious. The dragon turtle can breathe air and water."));

        ArrayList<String> actions13 = new ArrayList<String>();
        actions13.add(new String("Multiattack. The gargoyle makes two attacks: one with its bite and one with its claws."));
        actions13.add(new String("Bite. Melee Weapon Attack: +4 to hit, reach 5 ft., one target. Hit: 5 (1d6 + 2) piercing damage."));
        actions13.add(new String("Claws. Melee Weapon Attack: +4 to hit, reach 5 ft., one target. Hit: 5 (1d6 + 2) slashing damage."));
        ArrayList<String> special13 = new ArrayList<String>();
        special13.add(new String("False Appearance. While the gargoyle remains motionless, it is indistinguishable from an inanimate statue."));

        ArrayList<String> actions14 = new ArrayList<String>();
        actions14.add(new String("Multiattack. The bear makes two attacks: one with its bite and one with its claws."));
        actions14.add(new String("Bite. Melee Weapon Attack: +5 to hit, reach 5 ft., one target. Hit: 8 (1d8 + 4) piercing damage."));
        actions14.add(new String("Claws. Melee Weapon Attack: +5 to hit, reach 5 ft., one target. Hit: 11 (2d6 + 4) slashing damage."));
        ArrayList<String> special14 = new ArrayList<String>();
        special14.add(new String("Keen Smell. The bear has advantage on Wisdom (Perception) checks that rely on smell."));

        ArrayList<String> actions15 = new ArrayList<String>();
        actions15.add(new String("Bite. Melee Weapon Attack: +4 to hit, reach 5 ft., one creature. Hit: 4 (1d4 + 2) piercing damage."));
        actions15.add(new String("Spear. Melee or Ranged Weapon Attack: +4 to hit, reach 5 ft. or range 20/60 ft., one target. Hit: 5 (1d6 + 2) piercing damage, or 6 (1 d8 + 2) piercing damage if used with two hands to make a melee attack."));
        actions15.add(new String("Longbow. Ranged Weapon Attack: +3 to hit, range 150/600 ft. , one target. Hit: 5 (1d8 + 1) piercing damage."));
        ArrayList<String> special15 = new ArrayList<String>();
        special15.add(new String("Rampage. When the gnoll reduces a creature to 0 hit points with a melee attack on its turn, the gnoll can take a bonus action to move up to half its speed and make a bite attack."));


        monsters.add(new Monster("Ape","Medium beast","Unaligned",12,19,30,16,14,14,6,12,7,"Athletics +5, Perception +3","-","-","-","-","Passive Perception 13","-","1/2",actions1,special1));
        monsters.add(new Monster("Blink Dog","Medium fey","Lawful Good",13,22,40,12,17,12,10,13,11,"Perception +3, Stealth +5","-","-","-","-","Passive Perception 13","Understands Sylvan but can't speak it","1/4",actions2,special2));
        monsters.add(new Monster("Boar","Medium beast","Unaligned",11,11,40,13,11,12,2,9,5,"-","-","-","-","-","Passive Perception 13","-","1/2",actions3,special3));
        monsters.add(new Monster("Phase Spider","Large monstrosity","Unaligned",13,32,30,15,15,12,6,10,6,"Stealth +6","-","-","-","-","Darkvision 60 ft., Passive Perception 10","-","3",actions4,special4));
        monsters.add(new Monster("Quipper","Tiny beast","Unaligned",13,1,0,2,16,9,1,7,2,"-","-","-","-","-","Darkvision 60 ft., Passive Perception 8","-","0",actions5,special5));
        monsters.add(new Monster("Bandit","Medium humanoid (any race)","Any non-lawful alignment",12,11,30,11,12,12,10,10,10,"-","-","-","-","-","Passive Perception 10","Any 1 language (usually Common)","1/8",actions6,special6));
        monsters.add(new Monster("Owlbear","Large monstrosity","Unaligned",13,59,40,20,12,17,3,12,7,"Perception +3","-","-","-","-","Darkvision 60 ft., Passive Perception 13","-","3",actions7,special7));
        monsters.add(new Monster("Commoner","Medium humanoid (any race)","Any alignment",10,4,30,10,10,10,10,10,10,"-","-","-","-","-","Passive Perception 10","Any 1 language (usually Common)","0",actions8,special8));
        monsters.add(new Monster("Crawling Claw","Tiny undead","Neutral evil",12,2,20,13,14,11,5,10,4,"-","-","poison","-","charmed, exhaustion, poisoned","Blind sight 30 ft. (blind beyond this radius), Passive Perception 10","Understands Common but can't speak","0",actions9,special9));
        monsters.add(new Monster("Zombie","Medium undead","Neutral evil",8,22,20,13,6,16,3,6,5,"-","WIS +0","poison","-","poisoned","Darkvision 60 ft., Passive Perception 8","Understands the languages it knew in life, but can't speak","1/4",actions10,special10));
        monsters.add(new Monster("Tarrasque","Gargantuan monstrosity (titan)","Unaligned",25,676,40,30,11,30,3,11,11,"-","INT +5, WIS +9, CHA +9","fire; poison; bludgeoning, piercing, and slashing from non-magical weapons","-","charmed, frightened, paralyzed, poisoned","Blindsight 120ft., Passive Perception 10","-","30",actions11,special11));
        monsters.add(new Monster("Dragon Turtle","Gargantuan dragon","Neutral",20,341,20,25,10,20,10,12,12,"-","DEX +5, CON +10, WIS +6","-","fire","-","Darkvision 120 ft., Passive Perception 11","Aquan, Draconic","17",actions12,special12));
        monsters.add(new Monster("Gargoyle","Medium elemental","Chaotic evil",15,52,30,15,11,16,6,11,7,"-","-","poison","bludgeoning, piercing, and slashing from non-magical weapons that aren't adamantine","exhaustion, petrified, poisoned","Darkvision 60 ft., Passive Perception 10","Terran","2",actions13,special13));
        monsters.add(new Monster("Brown Bear","Large beast","Unaligned",11,34,40,19,10,16,2,13,7,"Perception +3","-","-","-","-","Passive Perception 13","-","1",actions14,special14));
        monsters.add(new Monster("Gnoll","Medium humanoid (gnoll)","Chaotic evil",15,22,30,14,12,11,6,10,7,"-","-","-","-","-","Darkvision 60 ft., Passive Perception 10","Gnoll","1/2",actions15,special15));

        Collections.sort(monsters, new MonsterNameComparator());
        return monsters;
    }


}
