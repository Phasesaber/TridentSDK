/*
 * Trident - A Multithreaded Server Alternative
 * Copyright 2014 The TridentSDK Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.tridentsdk.meta;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest {

    @Test
    public void testClass() throws Exception{

        Message message = new Message();
        message.text("Hello World");
        message.color(ChatColor.AQUA);
        message.clickEvent(new ClickEvent().action(ClickEvent.ClickAction.SUGGEST_COMMAND).value("Click"));
        message.hoverEvent(new HoverEvent().action(HoverEvent.HoverAction.SHOW_TEXT).value("Hover"));

        if(message.getMessage() == null){
            Assert.fail();
        }

        Assert.assertEquals(message.asJson(), "{\"text\":\"Hello World\",\"color\":\"aqua\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"Click\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"Hover\"}}");

    }
}