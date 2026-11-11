/**
 * GameSpec.java
 *
 * OneMap: Army vs Ants
 * Мобильд зориулсан, эх тоглоомтой төстэй 3D хэв маягийн тоглоомын шаардлага.
 *
 * Тайлбар:
 * - Эх тоглоомын жинхэнэ 3D дүрс, загварын файлууд энэ кодод байхгүй.
 * - 3D тоглоом болгохын тулд LibGDX зэрэг Java-д суурилсан 3D engine хэрэгтэй.
 */
public final class GameSpec {

    private GameSpec() {
        // Utility class; do not instantiate.
    }

    /** Тоглоомыг эх хувилбартай төстэй 3D хэлбэрээр хийх. */
    public static final String VISUAL_STYLE = "3D, similar to the original game";

    /** Ant-уудын хамгийн их тоо. */
    public static final int MAX_ANTS = 700;

    /** Ant-ийн тоо үүнд хүрэхэд дахин гаргах нөхцөл эхэлнэ. */
    public static final int ANT_REPLENISH_THRESHOLD = 690;

    /** Нэг удаагийн шинэ Ant давалгаа. */
    public static final int ANTS_PER_WAVE = 10;

    /**
     * Дараагийн давалгаа гарах хүлээлгийн хугацаа секундээр.
     * Энэ хугацааг хэрэглэгч одоогоор тодорхойлоогүй тул тохируулах шаардлагатай.
     */
    public static final int ANT_WAVE_DELAY_SECONDS = -1;

    public enum Winner {
        ARMY,
        ANTS,
        NONE
    }

    /**
     * Army-ийн бүх цэрэг устсан бол Army ялагдана.
     * Ant Hill устсан бол Ants ялагдана.
     */
    public static Winner getWinner(int livingArmyCount, int antHillHealth) {
        if (livingArmyCount <= 0) {
            return Winner.ANTS;
        }

        if (antHillHealth <= 0) {
            return Winner.ARMY;
        }

        return Winner.NONE;
    }

    /**
     * Ant-ийн тоо 690 буюу түүнээс цөөн болсон үед
     * давалгаагаар гаргах Ant-ийн тоог тооцно.
     *
     * Хүлээлгийн хугацаа дууссаны дараа энэ аргыг ашиглана.
     */
    public static int getAntsToSpawn(int livingAntCount) {
        if (livingAntCount > ANT_REPLENISH_THRESHOLD) {
            return 0;
        }

        int availableSpace = MAX_ANTS - livingAntCount;
        return Math.max(0, Math.min(ANTS_PER_WAVE, availableSpace));
    }
}
