package br.com.reips.emites.server;

import java.util.Set;
import java.util.TreeSet;

import org.apache.mina.filter.codec.ProtocolCodecSession;
import org.junit.Assert;
import org.junit.Test;

import br.com.reips.emites.constants.Constants;
import br.com.reips.emites.model.Search;

public class ProcessorTest {

    @Test
    public void processAvengersQuery() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor = new Processor(session, new Search("Avengers"));
        processor.run();
        Assert.assertEquals(1, session.getWrittenMessages());
    }

    @Test
    public void processAvengersQueryResponse() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor = new Processor(session, new Search("Avengers"));
        Assert.assertEquals("3286:A Daughter's Revenge\n" +
                "A Soldier's Revenge\n" +
                "A Vingança do Águia\n" +
                "Alien Avengers\n" +
                "Alien Avengers II\n" +
                "Alien Space Avenger\n" +
                "Arms of the Avenger\n" +
                "Arthur et la vengeance de Maltazard\n" +
                "Avenge\n" +
                "Avenge the Crows\n" +
                "Avengeance\n" +
                "Avenged\n" +
                "Avenged\n" +
                "Avenged\n" +
                "Avenged\n" +
                "Avengelyne\n" +
                "Avengement\n" +
                "Avengement\n" +
                "Avenger\n" +
                "Avenger\n" +
                "Avenger\n" +
                "Avenger\n" +
                "Avenger\n" +
                "Avenger\n" +
                "Avenger\n" +
                "Avenger\n" +
                "Avenger Dogs\n" +
                "Avengers\n" +
                "Avengers\n" +
                "Avengers\n" +
                "Avengers\n" +
                "Avengers\n" +
                "Avengers #1\n" +
                "Avengers 2\n" +
                "Avengers Assemble\n" +
                "Avengers Assemble!\n" +
                "Avengers Grimm\n" +
                "Avengers Grimm: Time Wars\n" +
                "Avengers Land Mystery\n" +
                "Avengers S.T.A.T.I.O.N.\n" +
                "Avengers Social Club\n" +
                "Avengers of Justice: Farce Wars\n" +
                "Avengers of the Reef\n" +
                "Avengers: Age of Ultron\n" +
                "Avengers: Damage Control\n" +
                "Avengers: Endgame\n" +
                "Avengers: Infinity War\n" +
                "Avengers: Legacy\n" +
                "Avengers: United They Stand\n" +
                "Avenging Angel\n" +
                "Avenging Angel\n" +
                "Avenging Angelo\n" +
                "Avenging Force\n" +
                "Avenging the Avengers\n" +
                "Baby Avengers\n" +
                "Berrenger's\n" +
                "Bikini Avengers\n" +
                "Blue Avengers\n" +
                "Burka Avenger\n" +
                "Captain America: Civil War\n" +
                "Captain America: The First Avenger\n" +
                "Captain America: The Winter Soldier\n" +
                "Cats & Dogs: The Revenge of Kitty Galore\n" +
                "Christmas Scavenger Hunt\n" +
                "Citizen Toxie: The Toxic Avenger IV\n" +
                "Combate Mortal\n" +
                "Dark Avenger\n" +
                "Dark Avengers\n" +
                "Deadly Scavengers\n" +
                "Die Hard with a Vengeance\n" +
                "Ghost Rider: Spirit of Vengeance\n" +
                "Halloween 5: The Revenge of Michael Myers\n" +
                "Heaven's Messenger\n" +
                "Hercules the Avenger\n" +
                "I Am Vengeance: Retaliation\n" +
                "I Spit on Your Grave: Vengeance is Mine\n" +
                "Invisible Avenger\n" +
                "Jaws: The Revenge\n" +
                "Lady Avenger\n" +
                "Lego Marvel's Avengers\n" +
                "Los Avengers\n" +
                "Marvel Avengers Academy\n" +
                "Marvel Future Avengers\n" +
                "Marvel's Avengers\n" +
                "Mask of the Avenger\n" +
                "Mister X\n" +
                "Naked Avenger\n" +
                "New Avengers\n" +
                "Next Avengers: Heroes of Tomorrow\n" +
                "Ninja Operation 6: Champion on Fire\n" +
                "Novgorodtsy\n" +
                "Os Punhais do Vingador\n" +
                "Os Vingadores Mascarados\n" +
                "Passengers\n" +
                "Passengers\n" +
                "Revenge Ride\n" +
                "Revenger\n" +
                "Revengers Tragedy\n" +
                "Scavenger\n" +
                "Scavenger\n" +
                "Scavenger\n" +
                "Scavenger\n" +
                "Scavenger\n" +
                "Scavenger Hunt\n" +
                "Scavenger Killers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Scavengers\n" +
                "Skavengers\n" +
                "Skavengers\n" +
                "Spanish Avengers\n" +
                "Starvengers\n" +
                "Teen Avengers\n" +
                "Teenage Alien Avengers\n" +
                "The Avenger\n" +
                "The Avenger\n" +
                "The Avenger\n" +
                "The Avenger\n" +
                "The Avenger\n" +
                "The Avenger\n" +
                "The Avenger\n" +
                "The Avenger\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers\n" +
                "The Avengers #1\n" +
                "The Avengers #1\n" +
                "The Avengers: Earth's Mightiest Heroes\n" +
                "The Avenging\n" +
                "The Avenging Angel\n" +
                "The Avenging Fist\n" +
                "The Avenging Quartet\n" +
                "The Avenging Silence\n" +
                "The Dark Avengers\n" +
                "The Double-D Avenger\n" +
                "The Four Musketeers: Milady's Revenge\n" +
                "The Messengers\n" +
                "The Messengers\n" +
                "The New Avengers\n" +
                "The Revenge\n" +
                "The Revenge\n" +
                "The Revenger\n" +
                "The Revenger\n" +
                "The Revengers\n" +
                "The Revengers\n" +
                "The Revengers\n" +
                "The Revengers' Comedies\n" +
                "The Scavenger\n" +
                "The Scavengers\n" +
                "The Scavengers\n" +
                "The Scavengers\n" +
                "The Scavengers\n" +
                "The Scavengers\n" +
                "The Scavengers\n" +
                "The Scavengers\n" +
                "The Scavengers\n" +
                "The Street Avenger\n" +
                "The Three Avengers\n" +
                "The Toxic Avenger\n" +
                "The Toxic Avenger\n" +
                "The Toxic Avenger Part II\n" +
                "Three Avengers\n" +
                "To Avenge\n" +
                "Transformers: Revenge of the Fallen\n" +
                "Ultimate Avengers II\n" +
                "Ultimate Avengers: The Movie\n" +
                "Venger\n" +
                "Vingadores do Espaço\n" +
                "Woman Avenger\n" +
                "Zorro, the Avenger\n", processor.searchMovies());
    }

    @Test
    public void processCubeQuery() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor = new Processor(session, new Search("Cube"));
        processor.run();
        Assert.assertEquals(1, session.getWrittenMessages());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void processCubeQueryResponse() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor = new Processor(session, new Search("Cube"));
        Assert.assertEquals("2374:A Cube & a Button\n" +
                "A Cube of Sugar\n" +
                "A Cube of Sugar\n" +
                "Are You Being Served?\n" +
                "Ass Cubes\n" +
                "Borg Cube\n" +
                "Chicken Cube\n" +
                "Citizen Cube\n" +
                "Classic Cubes\n" +
                "Cloth Cube\n" +
                "Companion Cubes\n" +
                "Cool Cubed\n" +
                "Cub\n" +
                "Cuba\n" +
                "Cuban Fury\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube\n" +
                "Cube Bros\n" +
                "Cube Game\n" +
                "Cube Machine\n" +
                "Cube Quest\n" +
                "Cube Runner\n" +
                "Cube Season\n" +
                "Cube Van\n" +
                "Cube Wars\n" +
                "Cube Zero\n" +
                "Cube Zombies\n" +
                "Cube of Death\n" +
                "Cube of Evil Spirits\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed\n" +
                "Cubed Trailer\n" +
                "Cubers\n" +
                "Cubes\n" +
                "Cubes\n" +
                "Cubes\n" +
                "Cubes\n" +
                "Cubes\n" +
                "Cubes\n" +
                "Cube²: Hypercube\n" +
                "Cubicles\n" +
                "Cubing a Round\n" +
                "Cubs\n" +
                "Cubs\n" +
                "Cubs\n" +
                "C³: C Cube\n" +
                "Dark Mind\n" +
                "Death by Cube\n" +
                "Do You Believe?\n" +
                "Doug Cubed\n" +
                "Eating in Cubes\n" +
                "Farewell My Concubine\n" +
                "Fear Cubed\n" +
                "Friday: An Indroduction by Ice Cube\n" +
                "Gelatinous Cube\n" +
                "Gleaming the Cube\n" +
                "God is a Cube: Programming Robot Cubes\n" +
                "Greening the Cube\n" +
                "Gros cubes\n" +
                "Hungarian Cube\n" +
                "I Am Cuba\n" +
                "I Love You, Beth Cooper\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube\n" +
                "Ice Cube!\n" +
                "Ice Cube: Friday\n" +
                "Ice Cube: Go To Church\n" +
                "Ice Cube: It Was a Good Day\n" +
                "Ice Cubed\n" +
                "Ice Cubed\n" +
                "In Cube\n" +
                "In the Cube\n" +
                "Incubus\n" +
                "Inside the Cube\n" +
                "Inside the Rubik's Cube\n" +
                "Jungle Cubs\n" +
                "Jurassik cube\n" +
                "Kenobi Cube\n" +
                "L'auberge espagnole\n" +
                "Le Cube\n" +
                "Le cube\n" +
                "Lone Wolf and Cub: Sword of Vengeance\n" +
                "Love Cube\n" +
                "Love Cubed\n" +
                "MacGruber\n" +
                "Metatron's Cube\n" +
                "Nissan Cube\n" +
                "No Cubes\n" +
                "Os Cachorros\n" +
                "Podcast Cube\n" +
                "Proton Cube\n" +
                "Puberty Blues\n" +
                "Puberty Blues\n" +
                "Ruben's Cube\n" +
                "Rubik's Cube\n" +
                "Rubik's Cube\n" +
                "Rubik's Cube\n" +
                "Rubik's Cube\n" +
                "Rubik's Cube\n" +
                "Rubik's cube\n" +
                "Rubik, the Amazing Cube\n" +
                "Rubix Cubed\n" +
                "Ruby Cubed\n" +
                "Scrubs\n" +
                "Scrubs: Interns\n" +
                "Story of a Cube\n" +
                "Stuber\n" +
                "Subspecies\n" +
                "Succubus\n" +
                "Sugar Cube\n" +
                "Sugar Cube\n" +
                "Sugar Cubes\n" +
                "Taming of the Cube\n" +
                "Tariq's Cube\n" +
                "The Big Cube\n" +
                "The Black Cube\n" +
                "The Black Cube\n" +
                "The Concubine\n" +
                "The Crystal Cube\n" +
                "The Cuban\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube\n" +
                "The Cube Phantom\n" +
                "The Cube Root\n" +
                "The Cube of Truth\n" +
                "The Cubeez\n" +
                "The Cubing\n" +
                "The Glass Cube\n" +
                "The House of Small Cubes\n" +
                "The Incubus\n" +
                "The Kubrick's Cube\n" +
                "The Magic Cube\n" +
                "The Mysterious Cube\n" +
                "The Pet Cube\n" +
                "The Speed Cubers\n" +
                "The Square of the Cube\n" +
                "The Substitute\n" +
                "The Substitute\n" +
                "The Sugar Cubes\n" +
                "The Votive Cube\n" +
                "This Is Not a Cube\n" +
                "Time Cube\n" +
                "Time Cube\n" +
                "Trouble Cubed\n" +
                "Tubelight\n" +
                "Two Cubes\n" +
                "Val Cubed\n" +
                "Valhara Cube\n" +
                "Why We Cube\n" +
                "Won't You Be My Neighbor?\n" +
                "Yellowstone Cubs\n" +
                "You're not a cube?\n", processor.searchMovies());

        Set<Search> searches = (TreeSet<Search>) session.getAttribute(Constants.SEARCHES);
        Assert.assertEquals(1, searches.size());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void processMultipleQuery() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor1 = new Processor(session, new Search("Cube"));
        processor1.run();
        Assert.assertEquals(1, session.getWrittenMessages());

        Processor processor2 = new Processor(session, new Search("Avengers"));
        processor2.run();
        Assert.assertEquals(2, session.getWrittenMessages());

        Set<Search> searches = (TreeSet<Search>) session.getAttribute(Constants.SEARCHES);
        Assert.assertEquals(2, searches.size());
    }

}
