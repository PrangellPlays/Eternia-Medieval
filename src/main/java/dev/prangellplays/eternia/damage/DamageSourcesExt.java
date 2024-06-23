package dev.prangellplays.eternia.damage;

public interface DamageSourcesExt {
    default EterniaDamageSources eSources() {
        throw new IllegalStateException("Not transformed");
    }
}
