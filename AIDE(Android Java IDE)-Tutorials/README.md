**Guide For AIDE** (_Android Java IDE_ )
===========================
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _

This is **_unofficial_** guide created by **AIDE** user to help other user who was develop Android projects from **AIDE**. 

If you don't know what is this, please reffer to developer official website at [ http://www.android-ide.com/] [1] or you might be want to install the latest version of AIDE on [Google Play Store] [2].
[1]: http://www.android-ide.com/
[2]: https://play.google.com/store/apps/details?id=com.aide.ui 
-
This documentation is not for replacing any tutorials from developer official website. It just some of additional guide that is not available before, and here we are, writting this guide for you. 

## **Generate SSH key for Git Integration** 

See [http://www.android-ide.com/tutorial_git.html](http://www.android-ide.com/tutorial_git.html "Git Tutorial"). 

We need SSH key, because it will used for Git authentication to push, pull, commit, checkout an existing branch, create a new branch, delete a branch, and merge a branch into another branch to remote Git repository. 

To generate SSH key directly from your android device, you need **ConnectBot _SSH-Agent_** installed on your device. 

Install it from [Google Play Store](https://play.google.com/store/apps/details?id=com.madgag.ssh.agent "ConnectBot SSH-Agent") 

**Step-by-step**: 

  1. Open _ConnectBot_
  2. Tap on _menu_ button
  3. Choose _Manage Pubkeys_
  4. Tap on Menu once again and choose _Generate_
  5. Now, you have the option for key generation. Just Fill in the text field and then click _Generate_ 
  6. When all is done, you will see your generated key. Now, it's time to retrieve the public key by long tap on the key until you see menu pops up
  7. Choose _Copy public key_ and the key has copied to clipboard on your device
  8. Now open your text editor and paste the generate key. Save as **id _ rsa.pub** or **id _ dsa.pub** as you choose before in step (5)
  9. Move your _SSH key_ to **/mnt/sdcard/.ssh** directory
  10. Next, sign-in to your Github account, and click the “Account Settings” link in the top right navigation and then “SSH Keys” on the left nav. 
  11. Click **Add SSH key** 
  12. Fill in _Title_ and paste your public key on the text field 
  13. Click **Add Key** 
  14. Confirm the action by entering your GitHub password 
  15. Now you are done! 

See the complete guide on [Github](https://help.github.com/articles/generating-ssh-keys/) how to add your SSH key. 

**Contribute** 

You may contribute on this user guide for AIDE by **Fork** and **Pull Request** to this repository. 

This documentation is using **Markdown** text formatting. If you are not familiar yet with this text formatting, see https://guides.github.com/features/mastering-markdown/ 