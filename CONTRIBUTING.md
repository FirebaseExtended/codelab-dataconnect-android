# Contributing to codelab-dataconnect-android

We'd love for you to contribute to our source code and to make this project even better than it is today! Here are the guidelines we'd like you to follow:

- [Code of Conduct](#coc)
- [Question or Problem?](#question)
- [Issues and Bugs](#issue)
- [Feature Requests](#feature)
- [Submission Guidelines](#submit)
- [Coding Rules](#rules)
- [Signing the CLA](#cla)

## <a name="coc"></a> Code of Conduct

As contributors and maintainers of the codelab-dataconnect-android project, we pledge to respect everyone who contributes by posting issues, updating documentation, submitting pull requests, providing feedback in comments, and any other activities.

Communication through any of Firebase's channels (GitHub, StackOverflow, Google+, Twitter, etc.) must be constructive and never resort to personal attacks, trolling, public or private harassment, insults, or other unprofessional conduct.

We promise to extend courtesy and respect to everyone involved in this project regardless of gender, gender identity, sexual orientation, disability, age, race, ethnicity, religion, or level of experience. We expect anyone contributing to the project to do the same.

If any member of the community violates this code of conduct, the maintainers of the codelab-dataconnect-android project may take action, removing issues, comments, and PRs or blocking accounts as deemed appropriate.

If you are subject to or witness unacceptable behavior, or have any other concerns, please drop us a line at samstern@google.com.

## <a name="question"></a> Got a Question or Problem?

If you have questions about how to use the codelab-dataconnect-android, please open a Github issue. If you need help debugging your own app, please please direct these to [StackOverflow][stackoverflow] and use the `firebase` tag.

If you feel that we're missing an important bit of documentation, feel free to
file an issue so we can help. Here's an example to get you started:

```
What are you trying to do or find out more about?

Where have you looked?

Where did you expect to find this information?
```

## <a name="issue"></a> Found an Issue?
If you find a bug in the source code or a mistake in the documentation, you can help us by
submitting an issue. Even better you can submit a Pull Request with a fix.

See [below](#submit) for some guidelines.

## <a name="submit"></a> Submission Guidelines

### Submitting an Issue
Before you submit your issue search the archive, maybe your question was already answered.

If your issue appears to be a bug, and hasn't been reported, open a new issue.
Help us to maximize the effort we can spend fixing issues and adding new
features, by not reporting duplicate issues.  Providing the following information will increase the
chances of your issue being dealt with quickly:

* **Overview of the Issue** - if an error is being thrown a non-minified stack trace helps
* **Motivation for or Use Case** - explain why this is a bug for you
* **Environment** - is this a problem with all devices or only some?
* **Reproduce the Error** - provide a live example or a unambiguous set of steps.
* **Related Issues** - has a similar issue been reported before?
* **Suggest a Fix** - if you can't fix the bug yourself, perhaps you can point to what might be
  causing the problem (line of code or commit)

**If you get help, help others. Good karma rulez!**

Here's a template to get you started:

```
Device: 
Operating system version:
Firebase SDK version:

What steps will reproduce the problem:
1.
2.
3.

What is the expected result?

What happens instead of that?

Please provide any other information below, and attach a screenshot if possible.
```

### Submitting a Pull Request
Before you submit your pull request consider the following guidelines:

* Search [GitHub](https://github.com/firebaseextended/codelab-dataconnect-android/pulls) for an open or closed Pull Request
  that relates to your submission. You don't want to duplicate effort.
* Please sign our [Contributor License Agreement (CLA)](#cla) before sending pull
  requests. We cannot accept code without this.
* Make your changes in a new git branch:

     ```shell
     git checkout -b my-fix-branch master
     ```

* Create your patch, **including appropriate test cases**.
* Avoid checking in files that shouldn't be tracked (e.g `.tmp`, `.idea`). We recommend using a [global](#global-gitignore) gitignore for this.
* Commit your changes using a descriptive commit message.

     ```shell
     git commit -a
     ```
  Note: the optional commit `-a` command line option will automatically "add" and "rm" edited files.

* Build your changes locally to ensure all the tests pass:

    ```shell
   gulp
    ```

* Push your branch to GitHub:

    ```shell
    git push origin my-fix-branch
    ```

* In GitHub, send a pull request to `codelab-dataconnect-android:master`.
* If we suggest changes then:
    * Make the required updates.
    * Rebase your branch and force push to your GitHub repository (this will update your Pull Request):

      ```shell
      git rebase master -i
      git push origin my-fix-branch -f
      ```

That's it! Thank you for your contribution!

#### After your pull request is merged

After your pull request is merged, you can safely delete your branch and pull the changes
from the main (upstream) repository:

* Delete the remote branch on GitHub either through the GitHub UI or your local shell as follows:

    ```shell
    git push origin --delete my-fix-branch
    ```

* Check out the master branch:

    ```shell
    git checkout master -f
    ```

* Delete the local branch:

    ```shell
    git branch -D my-fix-branch
    ```

* Update your master with the latest upstream version:

    ```shell
    git pull --ff upstream master
    ```

## <a name="cla"></a> Signing the CLA

Please sign our [Contributor License Agreement][google-cla] (CLA) before sending pull requests. For any code
changes to be accepted, the CLA must be signed. It's a quick process, we promise!

[github]: https://github.com/firebaseextended/codelab-dataconnect-android
[google-cla]: https://cla.developers.google.com
[stackoverflow]: http://stackoverflow.com/questions/tagged/firebase
[global-gitignore]: https://help.github.com/articles/ignoring-files/#create-a-global-gitignore