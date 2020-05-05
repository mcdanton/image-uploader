# Image Uploader

 

## Getting Started

1. Clone Repository from Github
2. Run the app
3. Hit Simulate Images to mock uploaded images

## App Architecture

This app uses a MVVM+Repo design pattern with data binding and a single activity with multiple fragments. The biggest challenge in the designs is handling the results of an uploaded image. Both the ImageListFragment (home screen) and the ImageDetailsFragment (details screen) require the results from the networking call. To tackle this problem, I moved the networking calls into a Repository file similar to what I brought up in our discussion. The repository asyncronously uploads each image and on return, updates a Live Data field observed by both fragments' view models. This gives both fragment access to the returned image/progress. Using live data also handles the async return through LiveData.postValue().

The image properties in each view model are Live Data that is bound directly to the XML so the views are updated as these properties are. (note: I didn't want to complicate the adapter by adding view binding so adapter sets up its own view instead).

I tried hard to build something that would demonstrate the architecture pattern I had in mind without going overboard on the app itself. I tried to add comments where I made certain shortcuts to note that it the approach I would take normally. 