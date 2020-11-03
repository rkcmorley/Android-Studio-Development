# Android-Studio-Development
Week 2 
- Contains the true or false buttons along with a sign that pops up.
- The challenge has change the position of the pop-up sign.

Week 3
- Contains About Me app which has a scroll view that talks about your life in Canada.
- All of these was done with design view which is basically dragging and dropping elements into the phone. Very little to no coding!
- In design view, we assigned the properties and widgets with resource ID's. Very complex!


Week 4
- Created a Fragment class which is a piece of UI.
- We created a Fragment class that's associated with an XML file and this Fragment class contains a method to "inflate" it or in other words, render it.


Week 5
- We created View Model and View Model Factory classes.
- To use the View Model class, you'll need to add the View Model in the dependencies under the app > build.gradle.
- View Model is needed if the orientation of the the device changes, otherwise the data such as the score will be lost.
- View Model Factory is needed to instantiate the View Model classes, in case we have a lot of View Models with similar attributes to create.
- We also created an event listener to end the game. 
- The data from the Fragment classes are passed or binded into their respective View Model classes.
