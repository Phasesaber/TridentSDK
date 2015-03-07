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

package net.tridentsdk.entity.traits;

import net.tridentsdk.Position;
import net.tridentsdk.Trident;
import net.tridentsdk.entity.Entity;
import net.tridentsdk.entity.LivingEntity;
import net.tridentsdk.entity.Projectile;
import net.tridentsdk.entity.living.Player;
import net.tridentsdk.entity.living.ai.AiModule;
import net.tridentsdk.entity.living.ai.Path;
import net.tridentsdk.event.entity.EntityDamageEvent;

import java.util.concurrent.atomic.AtomicInteger;

public class LivingDecorationAdapter extends DecorationAdapter<LivingEntity> implements LivingEntity {
    private final LivingEntity entity;
    private final AtomicInteger restTicks = new AtomicInteger(0);
    private volatile AiModule ai;
    private volatile Path path;

    protected LivingDecorationAdapter(LivingEntity entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    public void hide(Entity entity) {
        this.entity.hide(entity);
    }

    @Override
    public void show(Entity entity) {
        this.entity.show(entity);
    }

    @Override
    public double health() {
        return entity.health();
    }

    @Override
    public void setHealth(double health) {
        entity.setHealth(health);
    }

    @Override
    public double maxHealth() {
        return entity.maxHealth();
    }

    @Override
    public void setMaxHealth(double maxHealth) {
        entity.setMaxHealth(maxHealth);
    }

    @Override
    public long remainingAir() {
        return entity.remainingAir();
    }

    @Override
    public void setRemainingAir(long ticks) {
        entity.setRemainingAir(ticks);
    }

    @Override
    public Position headLocation() {
        return entity.headLocation();
    }

    @Override
    public boolean canCollectItems() {
        return entity.canCollectItems();
    }

    @Override
    public EntityDamageEvent lastDamageEvent() {
        return entity.lastDamageEvent();
    }

    @Override
    public Player lastPlayerDamager() {
        return entity.lastPlayerDamager();
    }

    @Override
    public boolean isDead() {
        return entity.isDead();
    }

    @Override
    public <T extends Projectile> T launchProjectile(EntityProperties properties) {
        return entity.launchProjectile(properties);
    }

    @Override
    protected LivingEntity original() {
        return entity;
    }

    @Override
    public void setAiModule(AiModule module) {
        this.ai = module;
    }

    @Override
    public AiModule aiModule() {
        if (ai == null) {
            return Trident.instance().aiHandler().defaultAiFor(type());
        } else {
            return ai;
        }
    }

    public void performAiUpdate() {
        if (this.restTicks.get() == 0) {
            this.restTicks.set(this.aiModule().think(this));
        } else {
            this.restTicks.getAndDecrement();
            // TODO: follow path
        }
    }

    @Override
    public Path path() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
