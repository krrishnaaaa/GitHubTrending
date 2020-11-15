### Task: 
    1. List User GitHub repositories
    2. Show details of the repository

### Details:
    - Design Pattern Used: Model-View-Presenter
    - Networking Library: Retrofit2
    - Language Used: Kotlin

### Dependency Details: 
#### Networking & Support Libraries:
    - com.google.code.gson:gson:2.8.5
    - com.squareup.retrofit2:retrofit:2.9.0
    - com.squareup.retrofit2:converter-gson:2.9.0
    - com.squareup.retrofit2:adapter-rxjava2:2.9.0
    - com.squareup.okhttp3:okhttp:4.9.0

#### EventBus:
    - org.greenrobot:eventbus:3.2.0

### Package Details:
    - Root package: com.pcsalt.example.githubtrending

| Package Suffix | Description |
|-|-|
| . | Contains MainActivity |
| .base | Contains BasePresenterContract, can be extended to have base classes for Fragments and Activities |
| .detail | Contains Fragment, Presenter and PresenterContract to display Repository details |
| .model | Contains models used for data and EventBus |
| .network | Contains API related files. Create network connection, and call APIs |
| .trendinglist | Contains related files to display list of repository |
| .util | Contains divider decorator, but can be extended to store other utility classes. |
