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

package net.tridentsdk.entity.types;

/**
 * Possible rabbit types, color and friendliness
 *
 * @author The TridentSDK Team
 */
public enum RabbitType {
    BROWN(0),

    WHITE(1),

    BLACK(2),

    WHITE_AND_BLACK(3),

    GOLD(4),

    SALT_AND_PEPPER(5),

    KILLER_RABBIT(99);

    private final int id;

    RabbitType(int id) {
        this.id = id;
    }

    /**
     * Returns the {@code int} value of the RabbitType
     *
     * @param rabbitType RabbitType
     * @return {@code int} value of the RabbitType
     */
    public static int asInt(RabbitType rabbitType) {
        return rabbitType.asInt();
    }

    /**
     * Returns the {@code int} value of the RabbitType
     *
     * @return {@code int} value of the RabbitType
     */
    public int asInt() {
        return this.id;
    }
}
