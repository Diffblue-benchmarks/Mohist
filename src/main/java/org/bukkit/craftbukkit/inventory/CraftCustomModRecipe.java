package org.bukkit.craftbukkit.inventory;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.util.CraftNamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

/**
 * Bukkit API wrapper for non-vanilla IRecipe classes
 */
public class CraftCustomModRecipe implements Recipe, Keyed {
    private IRecipe iRecipe;
    private NamespacedKey key;

    public CraftCustomModRecipe(IRecipe iRecipe) {
        this(iRecipe, null);
    }

    public CraftCustomModRecipe(IRecipe iRecipe, ResourceLocation key) {
        this.iRecipe = iRecipe;
        try {
            this.key = (key != null ? CraftNamespacedKey.fromMinecraft(key) : NamespacedKey.randomKey());
        } catch (Exception e) {
            this.key = NamespacedKey.randomKey();
        }
    }

    @Override
    public ItemStack getResult() {
        return CraftItemStack.asCraftMirror(iRecipe.getRecipeOutput());
    }

    @Override
    public NamespacedKey getKey() {
        return this.key;
    }

    public IRecipe getHandle() {
        return iRecipe;
    }
}
