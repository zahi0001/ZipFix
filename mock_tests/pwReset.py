import pwinput
# requires a file, mockDatabase.txt
# all strings in mockDatabase.txt, on every line, are of the format
# email|password
# (note: no verification of if emails are actually valid emails)

# initializing an empty dictionary for a very crude database
loginDict = {}
with open("mockDatabase.txt", 'r') as f:
    for line in f:
        # splitting mockDatabase up via the bar
        split_string = line.strip().split('|')
        # adds to a dict
        loginDict[split_string[0]] = split_string[1]
    # prints the dictionary for debug reference purposes
    print("printing dict")
    print(loginDict)

    # initialize empty string for the prompts & "is this email in the list"
    email_input = ""
    valid_email = False
    while(not valid_email):
        email_input = input("enter email: ")
        # if it's not in the dictionary keys we loop until we get one
        valid_email = email_input in loginDict
    # probably randomize what these values are or something
    pw_match = False
    while (not pw_match):
        new_pw = pwinput.pwinput("new password: ")
        new_pw_verify = pwinput.pwinput("verify password: ")
        pw_match = (new_pw == new_pw_verify)
    ## random debug
    print("pw updated? maybe? i don't know")