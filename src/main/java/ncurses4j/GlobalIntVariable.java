/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ncurses4j;

import com.sun.jna.NativeLibrary;
import com.sun.jna.ptr.IntByReference;

public class GlobalIntVariable {
    private String         name;
    private IntByReference value;

    public GlobalIntVariable(String name) {
        this.name = name;
    }

    public synchronized int get() {
        if (value == null) {
            value = new IntByReference();
            value.setPointer(NativeLibrary.getInstance("ncurses").getGlobalVariableAddress(name));
        }

        return value.getValue();
    }
}
