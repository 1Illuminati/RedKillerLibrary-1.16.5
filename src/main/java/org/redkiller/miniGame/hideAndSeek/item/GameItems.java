package org.redkiller.miniGame.hideAndSeek.item;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.redkiller.item.ItemBuilder;

import java.util.Arrays;
import java.util.Collections;

public class GameItems {
    public static final ItemStack JACK_AXE;
    public static final ItemStack GRIM_REAPER_SCYTHE;
    public static final ItemStack RED_KILLER_DAGGER;
    public static final ItemStack DEATH_NOTE;

    public static final ItemStack MEDICAL_BAG;
    public static final ItemStack ARTIFICIAL_EYE_OF_GOD;
    public static final ItemStack COCAINE;
    public static final ItemStack NINJA_BOOK;
    public static final ItemStack INVINCIBLE_SHIELD;
    public static final ItemStack KOREA_MAN;
    public static final ItemStack BET;
    public static final ItemStack BLINDFOLD;
    public static final ItemStack LOCATION_CHANGE;
    public static final ItemStack SLEEP_GUN;
    public static final ItemStack ISIS;

    public static final ItemStack LOC_HELPER;

    public static final ItemStack[] MURDER_WEAPON;
    public static final ItemStack[] RUNNER_WEAPON;

    static {
        JACK_AXE = new ItemBuilder(Material.NETHERITE_AXE).setUnbreakable(true).addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES)
                .setCustomModelData(1).setDisplayName("§5§l잭§7의 §f§l도끼").addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 15, AttributeModifier.Operation.ADD_NUMBER)
                .addAttribute(Attribute.GENERIC_ATTACK_SPEED, -3, AttributeModifier.Operation.ADD_NUMBER).setLore(Arrays.asList(
                        "§f광폭화 - 우클릭, 쿨타임 : 30초",
                        "§7  > 잭이 약물을 투여하여 10초간 신속 III을 받습니다.",
                        "",
                        "§f발광 - 쉬프트 좌클릭, 쿨타임 : 60초, 사용가능횟수 : 5번",
                        "§7  > 모든 도망자들에게 15초간 발광을 부여합니다.",
                        "",
                        "§f구속 - 쉬프트 우클릭, 쿨타임 : 90초, 사용가능횟수 : 3번",
                        "§7  > 모든 도망자들에게 10초간 구속3을 부여합니다.",
                        "",
                        "§7도끼를 든 살인마 잭은 빠른속도로 달려들어",
                        "§7적을 도끼로 무참히 찍어버리는 살인마입니다.")).build();

        GRIM_REAPER_SCYTHE = new ItemBuilder(Material.NETHERITE_HOE).setUnbreakable(true).addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES)
                .setCustomModelData(2).setDisplayName("§2§l그림 리퍼§7의 §f§l낫").addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 8, AttributeModifier.Operation.ADD_NUMBER)
                .addAttribute(Attribute.GENERIC_ATTACK_SPEED, -2, AttributeModifier.Operation.ADD_NUMBER).setLore(Arrays.asList(
                        "§f재배 - 우클릭, 쿨타임 : 30초",
                        "§7  > 5초간 공격력이 대폭 증가합니다.",
                        "",
                        "§f깊은 어둠 - 쉬프트 좌클릭, 쿨타임 : 60초, 사용가능횟수 : 5번",
                        "§7  > 45초간 존재하지 않는 존재가 됩니다.",
                        "",
                        "§f공포 - 쉬프트 우클릭, 쿨타임 : 90초, 사용가능횟수 : 3번",
                        "§7  > 모든 도망자들에게 20초간 어둠을 부여합니다.",
                        "",
                        "§7그림 리퍼는 인간이라는 곡식을 심고 그것을 수확하는",
                        "§7신들의 농사를 돕는 성실한 농부입니다.")).build();

        RED_KILLER_DAGGER = new ItemBuilder(Material.NETHERITE_SWORD).setUnbreakable(true).addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES)
                .setCustomModelData(3).setDisplayName("§4§l붉은 살인마§7의 §f§l단검").addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 5, AttributeModifier.Operation.ADD_NUMBER)
                .addAttribute(Attribute.GENERIC_ATTACK_SPEED, -1, AttributeModifier.Operation.ADD_NUMBER).setLore(Arrays.asList(
                        "§f함정 - 우클릭, 쿨타임 : 30초",
                        "§7  > 지금 서 있는 자리 밑에 함정을 설치합니다. (최대 3개)",
                        "§7    함정을 밟은 도망자는 20초간 구속, 실명, 발광, 독, 어둠을 받습니다.",
                        "",
                        "§f회귀 - 쉬프트 좌클릭, 쿨타임 : 60초, 사용가능횟수 : 5번",
                        "§7  > 지금 서 있는 자리에 보이지 않는 와드를 설치합니다.",
                        "§7    다시 스킬을 사용하면 해당위치로 텔레포트 합니다.",
                        "",
                        "§f즉사 함정 - 쉬프트 우클릭, 쿨타임 : 90초, 사용가능횟수 : 3번",
                        "§7  > 지금 서 있는 자리 밑에 함정을 설치합니다.",
                        "§7    함정을 밟은 도망자는 사망합니다.",
                        "",
                        "§7이 게임의 제작자 이름과 같은 이 살인마는",
                        "§7기믹을 이용하여 적들을 공포에 몰아 넣습니다.")).build();

        DEATH_NOTE = new ItemBuilder(Material.IRON_INGOT).setUnbreakable(true).addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES)
                .setCustomModelData(3).setDisplayName("§8§l키라§7의 §f§l데스노트").addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 3, AttributeModifier.Operation.ADD_NUMBER)
                .addAttribute(Attribute.GENERIC_ATTACK_SPEED, 1, AttributeModifier.Operation.ADD_NUMBER).setLore(Arrays.asList(
                        "§f이름 적기 - 채팅, 쿨타임 : 1초",
                        "§7  > 채팅창에 닉네임을 적을수 있습니다.",
                        "§7    한번이라도 때린적 있는 플레이어라면 해당 플레이어는 사망합니다.",
                        "§7    키라는 오로지 단 하나의 스킬만 존재합니다.",
                        "",
                        "§7세상은 썩어있다. 썩어있는 녀석은 죽는 게 나아.")).build();

        MURDER_WEAPON = new ItemStack[]{RED_KILLER_DAGGER, GRIM_REAPER_SCYTHE, JACK_AXE};

        MEDICAL_BAG = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(1).setDisplayName("§f부활").setLore(Arrays.asList(
                "§f부활 - 우클릭, 쿨타임 : 240초",
                "§7  > 랜덤으로 죽은 도망자중 한명을 부활시킵니다.",
                "",
                "§7사람을 살리는 엄청난 능력 근데 랜덤이네?")).build();

        ARTIFICIAL_EYE_OF_GOD = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(2).setDisplayName("§f천리안").setLore(Arrays.asList(
                "§f천리안 - 우클릭, 쿨타임 : 30초",
                "§7  > 10초간 살인마에게 발광을 부여합니다.",
                "",
                "§7어째서인지 내가 능력을 쓰면 남들도 보인다.")).build();

        COCAINE = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(3).setDisplayName("§f아드레날린").setLore(Arrays.asList(
                "§f기분이 좋아지는 약 - 우클릭, 쿨타임 : 30초",
                "§7  > 7초간 신속 II를 받습니다.",
                "",
                "§7우리 마린 영양간식")).build();

        NINJA_BOOK = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(4).setDisplayName("§f투명화").setLore(Arrays.asList(
                "§f투명화 - 우클릭, 쿨타임 : 50초",
                "§7  > 20초간 투명화를 받습니다.",
                "",
                "§7파티클 보이는거 주의하세요 ㅎㅎ")).build();

        INVINCIBLE_SHIELD = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(5).setDisplayName("§f무적").setLore(Arrays.asList(
                "§f무적 - 우클릭, 쿨타임 : 30초",
                "§7  > 8초간 저항 V를 받습니다.",
                "",
                "§7그림 리퍼를 행복하게 해주는 아이")).build();

        KOREA_MAN = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(6).setDisplayName("§f무능력").setLore(Arrays.asList(
                "§f무능력 - 우클릭, 쿨타임 : ㅋ초",
                "§7  > 놀랍게도 아무 일도 일어나지 않습니다.",
                "",
                "§7ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ")).build();

        BET = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(7).setDisplayName("§f밀치기").setLore(Arrays.asList(
                "§f밀치기 - 우클릭, 쿨타임 : 30초",
                "§7  > 3초간 아이템에 밀치기 X 인챈트가 부여됩니다.",
                "",
                "§7깡!")).build();

        BLINDFOLD = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(8).setDisplayName("§f실명").setLore(Arrays.asList(
                "§f실명 - 우클릭, 쿨타임 : 30초",
                "§7  > 4초간 살인마가 실명에 걸립니다.",
                "",
                "§7살인마의 멘탈 건강을 위한 최고의 선택")).build();

        LOCATION_CHANGE = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(9).setDisplayName("§f위치바꾸기").setLore(Arrays.asList(
                "§f위치 바꾸기 - 우클릭, 쿨타임 : 45초",
                "§7  > 살인마와 위치를 바꿉니다.",
                "",
                "§7체인지!.")).build();

        SLEEP_GUN = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(10).setDisplayName("§f수면총").setLore(Arrays.asList(
                "§f수면 총알 - 우클릭, 쿨타임 : 50초",
                "§7  > 전방으로 눈덩이를 발사합니다. 피격시",
                "§7    피격당한 엔티티에게 5초간 구속 3를 줍니다.",
                "",
                "§7잘 자라~ 우리 아가~.")).build();

        ISIS = new ItemBuilder(Material.IRON_INGOT).setCustomModelData(11).setDisplayName("§f자폭병").setLore(Arrays.asList(
                "§f알라후 아크바르 - 사망, 쿨타임 : X",
                "§7  > 살인마에게 사망시 살인마에게 20초간 구속5, 발광을 부여합니다.",
                "",
                "§7알라를 위하여!")).build();

        RUNNER_WEAPON = new ItemStack[]{MEDICAL_BAG, ARTIFICIAL_EYE_OF_GOD, COCAINE, NINJA_BOOK,
                INVINCIBLE_SHIELD, KOREA_MAN, BET, BLINDFOLD, LOCATION_CHANGE, ISIS};

        LOC_HELPER = new ItemBuilder(Material.DIAMOND_AXE).setDisplayName("§fLocation Set Up Helper").setLore(Collections.singletonList("§f이 아이템은 게임의 플레이를 지원하기 위해 제작되었습니다.")).build();
    }
}
