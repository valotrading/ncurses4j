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

package ncurses4j.examples;

import com.sun.jna.Pointer;
import ncurses4j.NCurses;

public class HelloWorld {

    public static void main(String[] args) {
        Pointer stdscr;

        stdscr = NCurses.initscr();

        if (NCurses.has_colors()) {
            NCurses.start_color();

            if (NCurses.COLOR_PAIRS() > 1) {
                NCurses.init_pair((short) 1, NCurses.COLOR_BLACK, NCurses.COLOR_WHITE);
                NCurses.attron(NCurses.COLOR_PAIR(1));
            }
        }

        NCurses.attron(NCurses.A_BOLD);

        int maxx = NCurses.getmaxx(stdscr);
        int maxy = NCurses.getmaxy(stdscr);

        String message = "Hello World";

        int x = maxx / 2 - message.length() / 2;
        int y = maxy / 2;

        NCurses.erase();
        NCurses.mvprintw(y, x, message);
        NCurses.refresh();
        NCurses.getch();
        NCurses.endwin();
    }

}
