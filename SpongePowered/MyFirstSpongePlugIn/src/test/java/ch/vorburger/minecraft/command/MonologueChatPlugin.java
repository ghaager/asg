/*
 * This file is part of Michael Vorburger's SwissKnightMinecraft project, licensed under the MIT License (MIT).
 *
 * Copyright (c) Michael Vorburger <http://www.vorburger.ch>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ch.vorburger.minecraft.command;

import org.spongepowered.api.command.source.LocatedSource;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

// TODO This class should ultimately be moved into /SpongeTests/src/test/java/ch/vorburger/minecraft/testsinfra/tests
@Plugin(id = MonologueChatPlugin.ID, name = "Chat with yourself", description = "Integration Tests Self/Monologue Chat", version = "1.0")
public class MonologueChatPlugin extends AbstractPluginWithCommands {
	public final static String ID = "ch.vorburger.minecraft.tests.selfchat";

	@Command("Talk to yourself (just for tests)")
	public void sayself(LocatedSource source, String text) {
		source.sendMessage(Text.of(text));
	}

}
