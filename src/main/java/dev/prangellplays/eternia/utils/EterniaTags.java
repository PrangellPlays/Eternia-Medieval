package dev.prangellplays.eternia.utils;

import dev.prangellplays.eternia.Eternia;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class EterniaTags {
    public static class Blocks {
        public static final TagKey<Block> PHOENIX_CLAWS_MINEABLE =
                createBlockTag("mineable/phoenix_claws");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Eternia.MOD_ID, name));
        }
    }
}
