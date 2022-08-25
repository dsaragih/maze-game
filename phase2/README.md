# group_0241 ~ maze-game

## Requirements
You need JDK 17 to run this program, because libraries used in this project are not compatible with JDK 18.

This project is built using gradle and the GDX game library.

If loading this project for the first time, you will need to right-click "build.gradle" in the "maze-game" folder and select "Link Gradle Project"
## Launch Game (Shortcut)
To execute this program, run maze-game.core.src.console.launcher.DesktopLauncher.main()

Move around with the WASD keys and click on the screen with the mouse cursor to shoot.

At a merchant, press the number keys to buy items.

Explore all rooms and eradicate all enemies to win the game. Try not to die first!
## Login System (and launch game)
Instead of simply running the game, you may want to explore the login system.

To execute the login program, run maze-game.core.src.console.launcher.Main.main()

Have the console open as large as you can to not miss any text.

From here, you may enter 3 to run a demo of the game. This will not be logged. To have a game logged as played, log in first.

Enter 2 followed by the return key in the console to sign up. Your username cannot be the same as someone else's.

To log in, enter 1 followed by your username and password.

After login, you are able to access login history, add user, and exit by following the command table. An admin may also delete, ban, and unban other non-admin accounts. To have an admin account, you must be added by another admin.

IMPORTANT: Terminating the program through console (instead of selecting the exit option) will prevent any new data from being saved.

There is a built-in admin user:

Username: admin

Password: 123
