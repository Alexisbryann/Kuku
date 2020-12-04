package com.alexis.kuku.Database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.alexis.kuku.R;

public class DatabaseDataWorker {
    private SQLiteDatabase mDb;
    public DatabaseDataWorker(SQLiteDatabase db){ mDb = db;}

    public void insertBreeds() {
        insertBreed("Layer.\n",
                R.drawable.leghorn,

                "PURPOSE. \n" +
                        "\u2714 Specifically kept for Egg production, meat from layers is considered a by-product.\n" +
                        "\u2714 For commercial layers, the productive period is usually one " +
                            "year at an average production of Two hundred and forty Three hundred eggs a year.\n",

                "EXAMPLE.\n"+
                        "Leghorn.\n",

                "CHARACTERISTICS.\n" +
                        "\u2714 It's colour ranges are white,black or orange.\n" +
                        "\u2714 Usually light weight.\n" +
                        "\u2714 Have low tendencies for broodiness.\n" +
                        "\u2714 Can lay up to Three hundred eggs per year.\n");

        insertBreed("Layer.\n",
                R.drawable.isa_brown,

                "PURPOSE. \n" +
                        "\u2714 Specifically kept for Egg production, meat from layers is considered a by-product.\n" +
                        "\u2714 For commercial layers, the productive period is usually one " +
                        "   year at an average production of Two hundred and forty Three hundred eggs a year.\n",

                "EXAMPLE.\n" +
                        "Isa Brown.\n",

                "CHARACTERISTICS.\n" +
                        "\u2714 Cocks are usually white with black shades while hens are usually brownish in colour.\n" +
                        "\u2714 This is a hybrid bird.\n" +
                        "\u2714 Starts laying at four and a half to five months.\n" +
                        "\u2714 Have low tendencies for broodiness.\n");

        insertBreed("Broiler.\n",
                R.drawable.broiler,

                "PURPOSE. \n" +
                        "\u2714 These are specifically bred for meat production and their meat is very soft.\n" +
                        "\u2714 They grow very fast and attain market weight in about six to eight weeks of age if " +
                            "fed on feed rations that support their genetic requirements, by this time, they will have consumed about 5.5 kg of feed.\n" +
                        "\u2714 They attain live weight of about two to two and a half kg within seven to eight weeks of age.\n" +
                        "\u2714 Their production cycle is relatively short, ranging between six to eight weeks.\n",
                "EXAMPLE.\n" +
                        "Plymouth Rock, Cornish, Sussex, Brahma and hybrids.\n",

                "CHARACTERISTICS.\n" +

                        "\u2714 Comparatively, weigh much heavier than other poultry breeds.\n" +
                        "\u2714 Do not go broody.\n" +
                        "\u2714 Have high feed conversion efficiency.\n" +
                        "\u2714 Grow very fast.\n" +
                        "\u2714 They are very poor layers.\n" +
                        "\u2714 They can grow to a very large size.\n");

        insertBreed("Dual purpose.\n",
                R.drawable.oprington,

                "PURPOSE. \n" +
                        "These birds can be raised for either eggs or meat or for both.\n",

                "EXAMPLE.\n" +
                        "Orpington.\n",

                "CHARACTERISTICS.\n" +
                        "\u2714 Black, white, blue or brownish in colour.\n" +
                        "\u2714 Begin laying at five to six months of age.\n" +
                        "\u2714 Heavy bird attaining three and a half to four kg.\n");

        insertBreed("Dual purpose.\n", R.drawable.rhode_island_red,

                "PURPOSE. \n" +
                        "These birds can be raised for either eggs or meat or for both.\n",

                "EXAMPLE.\n" +
                        "Rhode Island Red.\n",

                "CHARACTERISTICS.\n" +
                        "\u2714 Brownish-red in colour.\n" +
                        "\u2714 Attains three and a half to four kg.\n" +
                        "\u2714 Brown shelled eggs.\n" +
                        "\u2714 Low tendencies for broodiness.\n");

        insertBreed("Indigenous (local).\n", R.drawable.kienyeji,

                "PURPOSE. \n" +
                        "This is the local chicken. Kept for both its meat and eggs.\n",

                "EXAMPLE.\n" +
                        "",

                "CHARACTERISTICS\n" +
                        "\u2714 Small body size.\n" +
                        "\u2714 Very low egg production, usually thirty to forty eggs per year.\n" +
                        "\u2714 Broody.\n" +
                        "\u2714 Good mothering ability.\n" +
                        "\u2714 Low growth rate and low meat yield.\n");

        insertBreed("IMPROVED INDIGENOUS CHICKEN.\n",
                R.drawable.kenbro,

                "PURPOSE. \n" +
                        "\u2714 Improved indigenous (kienyeji) chicken developed through genetic improvement of the local chicken.\n" +
                        "\u2714 This improved breed has superior qualities compared  to local breeds, these qualities include," +
                            "higher egg production, higher growth rate, higher mature weight and low tendencies for broodiness.\n",

                "EXAMPLE.\n" +
                        "Kenbro chicken.\n",

                "CHARACTERISTICS.\n" +
                        "\u2714 Dual purpose breed that requires less intensive management.\n" +
                        "\u2714 More resistant to diseases hence easily adapts to the local conditions.\n" +
                        "\u2714 Survives on free range local production system, though it is a heavy feeder.\n" +
                        "\u2714 Attains a mature weight of four and a half kg within five and a half months.\n" +
                        "\u2714 Tasty and soft meet, hence in demand in the market.\n");

        insertBreed("IMPROVED INDIGENOUS CHICKEN.\n", R.drawable.rainbow,

                "PURPOSE. \n" +
                        "\u2714 A number of improved indigenous (kienyeji) chicken have been developed through genetic improvement of the local chicken. \n" +
                        "\u2714 This improved breed has superior qualities compared  to local breeds, these qualities include," +
                            "higher egg production, higher growth rate, higher mature weight and low tendencies for broodiness.\n",

                "EXAMPLE.\n" +
                        "Rainbow Rooster.\n",

                "CHARACTERISTICS\n" +
                        "\u2714 Dual purpose breed with a high growth rate.\n" +
                        "\u2714 Can do well on free range local production system.\n" +
                        "\u2714 Attains a mature weight of four kg within six months.\n" +
                        "\u2714 Heavy feeder, this is suppressed by its good feed conversion efficiency.\n");

        insertBreed("IMPROVED INDIGENOUS CHICKEN.\n", R.drawable.kuroiler,

                "PURPOSE. \n" +
                        "\u2714 A number of improved indigenous (kienyeji) chicken have been developed through genetic improvement of the local chicken.\n" +
                        "\u2714 This improved breed has superior qualities compared  to local breeds, these qualities include," +
                            "higher egg production, higher growth rate, higher mature weight and low tendencies for broodiness.\n",

                "EXAMPLE.\n" +
                        "Kuroiler chicken.",

                "CHARACTERISTICS.\n" +
                        "\u2714 Dual purpose breed that can do well on free range.\n" +
                        "\u2714 Lays between one hundred and forty to one hundred and fifty eggs per year.\n" +
                        "\u2714 More resistant to diseases hence easily adapts to the local conditions.\n" +
                        "\u2714 Can scavenge on kitchen left overs and farm by-products.\n" +
                        "\u2714 Attains a mature weight of four kg within six months.\n" +
                        "\u2714 Does not brood, hence will not sit on eggs, a farmer will have to give its eggs to local chicken or use an incubator.\n");

        insertBreed("IMPROVED INDIGENOUS CHICKEN.\n",
                R.drawable.kari,

                "PURPOSE. \n" +
                        "\u2714 A number of improved indigenous (kienyeji) chicken have been developed through genetic improvement of the local chicken.\n" +
                        "\u2714 This improved breed has superior qualities compared  to local breeds, these qualities include," +
                            "higher egg production, higher growth rate, higher mature weight and low tendencies for broodiness.\n",

                "EXAMPLE.\n" +
                        "Improved KARI indigenous chicken.\n",

                "CHARACTERISTICS.\n" +
                        "\u2714 Dual purpose breed kept for both eggs and meat.\n" +
                        "\u2714 It is hardy and more resistant to diseases than hybrids.\n" +
                        "\u2714 Attains a mature weight of two and a half kg and above in five months for cocks" +
                            "while hens attain two kg and above in the same period.\n" +
                        "\u2714 Does quite well in egg production, producing up to two hundred and twenty eggs per year .\n");
    }

    private void insertBreed(String breed, int image, String purpose, String example, String characteristics) {

        ContentValues values = new ContentValues();

        values.put(DataBaseContract.BreedsEntry.COLUMN_BREED,breed);
        values.put(DataBaseContract.BreedsEntry.COLUMN_IMAGE, image);
        values.put(DataBaseContract.BreedsEntry.COLUMN_EXAMPLES,example);
        values.put(DataBaseContract.BreedsEntry.COLUMN_PURPOSE,purpose);
        values.put(DataBaseContract.BreedsEntry.COLUMN_CHARACTERISTICS,characteristics);

        long newRowId = mDb.insert(DataBaseContract.BreedsEntry.TABLE_NAME,null,values);
    }

    public void insertMains(){
        insertMain( "Breeds",R.drawable.breeds, "An overview of various chicken breeds and their characteristics.");
        insertMain("Housing and equipment",R.drawable.housing_and_equipment,"Recommendations on requirements and consideration while building a chicken coop.");
        insertMain("Brooding",R.drawable.brooding,"Describes how to provide heat for newly hatched chicks.");
        insertMain("Poultry management",R.drawable.battery_cages,"Entails various systems you can use to rear your chicken.");
        insertMain("Poultry health management",R.drawable.health_management,"Directions on how to ensure a healthy flock and diagnose common diseases early.");
        insertMain("Bad Habits",R.drawable.egg_eating,"Describes common bad habits among poultry and how to manage the vices.");
        insertMain("Best practice",R.drawable.best_practice,"Entails standard techniques and management strategies.");
    }
    private void insertMain(String title,int image, String description){
        ContentValues values = new ContentValues();

        values.put(DataBaseContract.MainEntry.COLUMN_TITLE,title);
        values.put(DataBaseContract.MainEntry.COLUMN_IMG,image);
        values.put(DataBaseContract.MainEntry.COLUMN_DESCRIPTION,description);

        long newRowId = mDb.insert(DataBaseContract.MainEntry.TABLE_NAME,null,values);
    }
    public void insertBadHabits(){
        insertBadHabit("Egg eating by chicken.\n",

                R.drawable.egg_eating,

                "WHAT IS IT? \n" +

                        "Sometimes birds develop the tendency to eat their own eggs.\n",

                " CAUSES. \n" +

                        "\u2714 It may start due to the presence of cracked eggs or accidental breaking of eggs and once" +
                        " the birds develop taste for it they start breaking their own eggs.\n" +
                        "\u2714 Factors responsible for breaking of egg or cracking of egg are thin or soft egg shell" +
                        " or lack of sufficient bedding material in the laying area.\n" +
                        "\u2714 Presence of eggs for longer period in the coop may also encourage the birds to start egg eating.\n" +
                        "\u2714 Nutritional deficiency, especially absence of calcium and vitamin D.\n ",

                " PREVENTION.\n" +

                        "\u2714 Isolate the birds which have developed this habit. \n" +
                            "\u2714 In consultation with the expert, the quantity of lime stone and protein should be increased in the diet. \n" +
                            "\u2714 Egg eaters should be kept in a cage in which egg rolls away, beyond the reach of the bird after laying of the eggs due to slope.\n" +
                            "\u2714 De-beaking also reduces this tendency. \n" +
                            "\u2714 Darkness in the laying area may prevent his habit. \n" +
                            "\u2714 Frequent collection of eggs.\n");

        insertBadHabit("Cannibalism.",

                R.drawable.cannibalism,

                " WHAT IS IT? \n" +

                        "\u2714 Cannibalism is a condition in which birds of a flock attack their pen mate and eat its flesh," +
                        "which may impose deep wounds and heavy mortality.\n" +
                        "\u2714 Pecking is common in laying birds. Once the birds adopt this vice it spreads rapidly through the flock.\n" +
                        "\u2714 Poultry farmer must remain vigilant to prevent cannibalism as it has got no direct treatment.\n" +
                        "\u2714 Presence of wounded or dead birds which are showing wound but otherwise appear healthy are indicative of cannibalism.\n",

                " CAUSES. \n" +

                        "\u2714 Overcrowding.\n" +
                        "\u2714 Bleeding in the external genitalia due to laying of large eggs.\n" +
                        "\u2714 Protein deficiency in the diet or provision of feeds or feeding/drinking space.\n" +
                        "\u2714 Lack of properly designed nest boxes.\n" +
                        "\u2714 Too much heat.\n" +
                        "\u2714 Loss of feathers from the body or bleeding from the skin due to parasitic infestation.\n" +
                        "\u2714 Wounds inflicted by fighting between the birds.\n",
                " PREVENTION.\n" +

                        "\u2714 De-beaking, which can be done right from the day old chicks to any age." +
                        " One- third of the upper beak and tip of the lower beak is to be trimmed.\n" +
                        "\u2714 To stop bleeding after de-beaking, hot iron rod is touched at the site of cut." +
                        "De-beaking must be performed by a competent and trained person, otherwise there may be excessive bleeding and the bird may die due to starvation.\n" +
                        "\u2714 Birds involved in cannibalism must be isolated and culled to stop this vice.\n" +
                        "\u2714 Provision of adequate feeders and drinkers.\n" +
                        "\u2714 Controlling stock density so that birds have adequate floor space for feeding, watering and exercise.\n");

        insertBadHabit("Egg hiding.",

                R.drawable.egg_hiding,

                " WHAT IS IT? \n"  +

                        "Poultry birds can hide the eggs in the field, bushes etc.\n",

                " CAUSES. \n" +

                        "\u2714 This habit may develop in the domestic fowl which are allowed ample freedom of movement.\n",

                " PREVENTION.\n" +

                        "\u2714 Restrict freedom of movement of the birds.\n" +
                        "\u2714 Laying area should be built inside poultry house and made comfortable by providing sawdust, dry grass etc.");

    }
    private void insertBadHabit(String habit, int image, String description, String causes, String prevention){

        ContentValues values = new ContentValues();

        values.put(DataBaseContract.BadHabitsEntry.COLUMN_HABIT,habit);
        values.put(DataBaseContract.BadHabitsEntry.COLUMN_IMAGE,image);
        values.put(DataBaseContract.BadHabitsEntry.COLUMN_DESCRIPTION,description);
        values.put(DataBaseContract.BadHabitsEntry.COLUMN_CAUSES,causes);
        values.put(DataBaseContract.BadHabitsEntry.COLUMN_PREVENTION,prevention);

        long newRowId = mDb.insert(DataBaseContract.BadHabitsEntry.TABLE_NAME,null,values);
    }
    public void insertBestPractices(){
        insertBestPractice(
                "Bio-security.",
                "\u2714 Well-defined bio-security practices throughout broiler production" +
                        " (pre-, during and post-placement) are crucial to successful poultry production.\n"+
                        "\u2714 Effective bio-security can aid hygiene, vermin and insect control on-farm " +
                        "and help to limit disease transmission within and between barns.");
        insertBestPractice("Downtime between flocks.",
                "\u2714 Adequate downtime of at least 14 days with appropriate cleaning and " +
                        "disinfection measures between flock placements helps to reduce transmission " +
                        "of disease between flocks and allows time to prepare for the next flock.");
        insertBestPractice("Pre-placement preparation.",
                "\u2714 Pre-placement preparation is needed before the new flock arrives to help " +
                        "prevent losses during brooding and the rest of grow out.\n" +
                        "\u2714 Checkpoints to keep in mind: heaters, floor temperature, temperature and relative humidity probes," +
                        "ventilation, drinkers, feeders, etc.");
        insertBestPractice("Brooding management",
                "\u2714 With today’s improved genetic capabilities and the fast growth of birds," +
                        " more time is being spent during the critical brooding phase. " +
                        "As a result, ensuring a good start in poultry production can have a significant " +
                        "impact on the future health and performance of the birds.\n" +
                        "\u2714 The brooding period is an important time for intestinal growth " +
                        "and the development of a balanced micro-flora.");
        insertBestPractice("Water management.",
                "\u2714 Drinking water accounts for 70–80 percent of the bird’s daily drinking needs." +
                        " Poultry will generally consume more water than feed. " +
                        "As a result, water is the most critical nutrient for poultry. " +
                        "An abundance of clean water will reduce challenges and maximize performance.\n" +
                "\u2714 Factors to consider when thinking about water management include:\n" +
                "\u2714 Cleanliness of drinker lines/regulators prior to flock placement and during production.\n" +
                "\u2714 Flushing water lines between flocks and during production.\n" +
                "\u2714 Drinker equipment maintenance.");
        insertBestPractice("Feed management.",
                "\u2714 Birds must have easy access to feed. Proper feeder line height corresponding " +
                        "to the height of the birds helps to reduce feed wastage and mixing feed with litter," +
                        " and it ensures that all birds have access to feed." +
                        " Adequate feed access is also achieved by following the feed line manufacturer’s " +
                        "recommendations for the number of birds per feed pan or line of trough feeder.\n" +
                        "\u2714 Birds will naturally peck at litter but avoiding “out-of-feed” events helps to " +
                        "reduce the potential for birds to peck excessively at the litter. " +
                        "Simple measures like activating trigger feed pans and monitoring " +
                        "feed bin levels during barn checks can help to prevent such events.\n" +
                        "\u2714 Good feed quality that avoids contaminants like mycotoxins is important to ensure performance.");
        insertBestPractice("Environmental management.",
                "\u2714 General environmental management of the barn includes many components, " +
                        "such as temperature, relative humidity, ventilation and lighting.\n" +
                        "\u2714 Understanding that these components work both separately and together" +
                        " can help to guide your management practices.");
        insertBestPractice("Mortality checks.",
                "\u2714 Cull diseased birds as early as possible.");
        insertBestPractice("Flock health management.",
                "\u2714 Work with your veterinarian to design a program customized for your flock’s health.");
    }
    private void insertBestPractice( String title, String measures){
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.BestPracticeEntry.COLUMN_TITLE,title);
        values.put(DataBaseContract.BestPracticeEntry.COLUMN_MEASURES,measures);

        long newRowId = mDb.insert(DataBaseContract.BestPracticeEntry.TABLE_NAME,null,values);

    }

    public void insertBrooding() {
        insertBrooding("Brooding is defined as the management of chicks from one day old to about 8 weeks of age, " +
                        "and it involves the provision of heat and other necessary care during chicks’ early growing period." +
                        "Brooding units are designed to house chicks from one day old until they no longer need supplementary heat (0-8 weeks).",
                "\n1. NATURAL BROODING.",
                R.drawable.natural_brooding,
                "This is done by the mother hen. After a hen has laid a couple of eggs, usually between 8-15, she goes broody. " +
                        "\nBroody is a psychologically controlled process where a hen begins to sit on her eggs with the aim of hatching them. " +
                        "\nAfter the eggs are hatched, the mother hen provides all the necessary condition for her chicks’ survival, especially heat, feed and water. " +
                        "\nThis is natural brooding.");
        insertBrooding("",
                "\n2. ARTIFICIAL BROODING.",
                R.drawable.artificial_brooding,
                "In artificial brooding, a farmer tries to simulate the natural brooding process by providing everything the mother hen could have provided. " +
                        "\nTherefore, artificial brooding involves providing heat, water, feed, and necessary veterinary attention to newly hatched chicks until they are able to regulate their body temperature." +
                        "\n\nECONOMIC BENEFITS OF ARTIFICIAL BROODING IN POULTRY MANAGEMENT.\n" +
                        "\u2714 Artificial brooding allows the farmer to brood a large number of chicks at a time. Ranging from several hundreds to thousands.\n" +
                        "\u2714 Artificial brooding allows for optimum performance of the chicks.\n" +
                        "\u2714 Chicks get the nutrients required through effective feeding practices.\n" +
                        "\u2714 Hens are used for brooder stock, and they lay more eggs instead of sitting on their eggs.\n" +
                        "\u2714 This is the only method that is suitable for commercial poultry production.\n" +
                        "\u2714 It allows for close monitoring of day old chicks.\n" +

                        "\nWHAT IS A BROODER ?\n" +
                        "A brooder is a poultry house fitted with heating equipment that allows a farmer to deliver controlled heating to the chicks. " +
                        "Other parameters that must be considered in a brooder house include ventilation/air circulation, relative humidity, lighting, space required, safety of the chicks, etc.\n\n" +

                        "BASIC COMPONENTS OF A BROODER HOUSE.\n\n" +
                        "1. Heat Source for brooding in poultry.\n" +
                        "There are a couple of heat sources that you can use for brooding in poultry management." +
                        "\nThe popular ones include:\n" +
                        "\u2714 Gas Brooder. It comprises of a gas heater that is powered by any cooking gas methane or LPG (propane and/or butane).\n" +
                        "The gas burner is usually covered with a layer of stainless steel to further distribute the heat.\n" +
                        "\u2714 Charcoal: This heat source involves the burning of charcoal in a coal pot. The coal pot can be made of iron or clay.\n" +
                        "\u2714 Electric brooder: The electric brooder replaces the gas brooder where there is electricity.\n" +
                        "\u2714 Apart from metered electricity bill involved, this is the cheapest.\n\n" +
                        "2. Brooder Guard.\n" +
                        "\u2714 Heat is a major component of brooding in poultry, hence, the need to conserve heat generated.\n" +
                        "\u2714 This is why a farmer must have a brooder guard within the brooding house to contain the chicks and ensure that they get the required heat.\n" +
                        "\u2714 A good brooder guard allows for easy extension as the chicks grow bigger.\n" +
                        "\u2714 It is important to give just the required space within the brooder guard in other to encourage fast growth and conserve energy and heat.\n" +
                        "\u2714 A brooder guard can be made of plastic, ply wood, metal or any other material, but it should be easily detachable.\n\n"+
                        "3. Heat Monitor or Thermometer.\n" +
                        "\u2714 You will be needing a thermometer to monitor and control heat within the brooder house.\n" +
                        "\u2714 Most farmers get digital thermometers and place within the brooder house.\n" +
                        "\u2714 One thing to note is that it should be placed at the ground level to read the exact temperature the birds are exposed to.\n" +

                        "\nPRE-BROODING, BROODING, AND POST-BROODING PRACTICES.\n" +

                        "Your success in brooding depends on the manner in which you approach the above. A good farmer must make adequate preparations for his chicks before their arrival. " +
                        "\nUpon their arrival, the chicks should also get the maximum care they can get, and the farmer must do some things after brooding to prepare for the next batch." +

                        "\n\nPRE-BROODING PRACTICES FOR SUCCESSFUL BROODING.\n" +

                        "This includes among others, the activities a farmer has to go through to prepare for successful brooding.\n" +
                        "\u2714 Seal up the brooder house with nylon or sacs. Only allow some room at the roof sides for air escape.\n" +
                        "\u2714 Block all holes and crevices to prevent rodents and other predators from entering and eating or agitating your chicks.\n" +
                        "\u2714 Check water troughs and water lines and seal all leakages.\n" +
                        "\u2714 Fumigate and disinfect the brooder house two weeks before chicks’ arrival. Note that you cannot use liquid disinfectants after you spread the bedding/litter material.\n" +
                        "\u2714 Provide bedding material, usually wood shavings of at least 6 cm in depth. Also make sure that you have some reserve.\n" +
                        "\u2714 Provide the adequate number of feeders and water troughs for the expected quantity of chicks.\n" +
                        "\u2714 Heat up the brooder house to required temperature at least 2 hours before chicks’ arrival.\n" +
                        "\u2714 Fill feeders with feed and drinkers with water at least 2 hours before chicks arrive. This is to ensure that the feed and water have the room temperature.\n" +

                        "\nBROODING PRACTICES.\n" +

                        "Upon chicks’ arrival, do the unboxing exercise as quickly as possible.\n" +
                        "\u2714 While you are unboxing, checked for deformed chicks and those with unhealed navel. Treat them to prevent omphalitis.\n" +
                        "\u2714 Check for underweight chickens and separate them from the rest. They might end up being runts. Separating them will allow you to manage them properly, giving them a better chance of survival.\n" +
                        "\u2714 Ensure that all the chicks have some water. Usually, you should provide anti-stress in their water. A perfect electrolyte you can use is coconut water.\n" +
                        "\u2714 Observe the chicks closely and see how they respond to the heat.\n" +
                        "\u2714 Always serve fresh feed and water.\n" +
                        "\u2714 Have antibiotics handy in case it is needed. But if you raise your chickens naturally like we do, you can consider using herbs and spices.\n" +
                        "\u2714 Follow hatchery vaccination schedule or go organic." +

                        "\n\nPOST-BROODING PRACTICES.\n\n" +
                        "When your chicks grow past the brooding age, they should be able to regulate their body temperature.\n" +
                        "At this stage, you will have to remove the nylon or sacs covering the sides of the brooding pen if you are raising them to maturity there.\n" +
                        "Otherwise, you move them to the grow-out location and prepare the brooding house for the next set.\n" +
                        "If this is the case, ensure that you do the following:\n" +
                        "\u2714 Remove bedding/litter material.\n" +
                        "\u2714 Sanitize the brooding house and equipment before the next batch.\n" +
                        "\u2714 Replace bedding/litter material.\n" +
                        "Reflect on your experience with the last batch and make any necessary adjustments. No two farms are the same, so you will have to go with what works best for you." +

                        "\n\nFEEDS AND FEEDING DURING BROODING IN POULTRY.\n" +
                        "Day old chick don’t eat much up to about 2 weeks of age. However, you must be ready for the increase in consumption from the third week.\n" +
                        "Because of chicks’ protein and energy requirement during brooding in poultry, the appropriate diet for them is the chick starter or super starter mash.\n" +
                        "Some use pelleted feed even at the chick’s young age.\n" +
                        "The most important qualities of the chicks’ diet are the small particle size and available crude protein (CP).\n" +
                        "Chicks are only able to ingest tiny particles of grains so the feed must not come with large grain particles that is meant for growers.");

    }
    private void insertBrooding(String definition, String type,int image, String description){
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.BroodingEntry.COLUMN_DEFINITION,definition);
        values.put(DataBaseContract.BroodingEntry.COLUMN_TYPE,type);
        values.put(DataBaseContract.BroodingEntry.COLUMN_IMAGE,image);
        values.put(DataBaseContract.BroodingEntry.COLUMN_DESCRIPTION,description);

        long newRowId = mDb.insert(DataBaseContract.BroodingEntry.TABLE_NAME,null,values);

    }
}
