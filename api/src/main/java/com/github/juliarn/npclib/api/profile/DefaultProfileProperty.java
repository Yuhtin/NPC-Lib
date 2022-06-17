/*
 * This file is part of npc-lib, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022 Julian M., Pasqual K. and contributors
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

package com.github.juliarn.npclib.api.profile;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class DefaultProfileProperty implements ProfileProperty {

  private final String name;
  private final String value;
  private final String signature;

  public DefaultProfileProperty(@NotNull String name, @NotNull String value, @Nullable String signature) {
    this.name = name;
    this.value = value;
    this.signature = signature;
  }

  @Override
  public @NotNull String name() {
    return this.name;
  }

  @Override
  public @NotNull String value() {
    return this.value;
  }

  @Override
  public @Nullable String signature() {
    return this.signature;
  }

  @Override
  public int hashCode() {
    return this.name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    // quick exit for the same instance
    if (obj == this) {
      return true;
    }

    // check for the type
    if (obj instanceof ProfileProperty) {
      ProfileProperty other = (ProfileProperty) obj;
      return this.name.equals(other.name())
        && this.value.equals(other.value())
        && Objects.equals(this.signature, other.signature());
    }

    return false;
  }
}