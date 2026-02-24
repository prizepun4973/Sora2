package dev.silentmoli.sora2.impl.gui;

import dev.silentmoli.sora2.api.manager.Modules;
import dev.silentmoli.sora2.api.render.GUIScreen;
import dev.silentmoli.sora2.api.render.widget.WWindow;
import dev.silentmoli.sora2.impl.module.client.UIModule;
import net.minecraft.client.input.KeyInput;


public class ClickUI extends GUIScreen {
    public ClickUI() {
        super();
    }

    @Override
    protected void init() {
        super.init();

        addWidget(new WWindow(this, 100, 100));
    }

    @Override
    public boolean keyPressed(KeyInput input) {
        if (input.isEscape()) {
            close();
            Modules.get(UIModule.class).setEnabled(false);
            return true;
        }
        return false;
    }
}
