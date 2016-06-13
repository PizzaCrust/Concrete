/*
 * Forge Mod Loader
 * Copyright (c) 2012-2013 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Contributors:
 *     cpw - implementation
 */
package net.minecraftforge.fml.relauncher;

import org.apache.logging.log4j.LogManager;

public class FMLLaunchHandler {

    public static Side side() {
        LogManager.getLogger("FMLFaker").info("Just faked SpongePowered Mixin!");
        return Side.SERVER;
    }

    public enum Side {
        CLIENT,
        SERVER,
    }
}
