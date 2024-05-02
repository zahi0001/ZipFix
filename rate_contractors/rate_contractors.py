import PySimpleGUI as sg
# This calculates the average rating of a contractor
# The file format is such
# username | rating | # of 1 star | # of 2 star | # of 3 start | # of 4 start | # of 5 star | total ratings

# The customer should have already been interacting with the contractor so their data should already
# be pulled in stored in a list

# Contractors current rating information
contractor = list({"bobTheBuilder|4.1|2|1|3|10|15"})

# The Idea is the the class splits up the data and the user enters their rating 1 through 5 and the add_new_rating calculates the new rating
class rate:
        # Calculates new rating by figuring out what the new user choose and including it in the new total
        def add_new_rating(number_of_type,total_ratings):

                new_rating = 0
                while new_rating > 5 or new_rating < 1:
                        new_rating = int(input("Enter your Rating from numbers 1-5:" + "\n"))
                        if(int(new_rating) == 1):
                                number_of_type[0] = number_of_type[0] + 1
                                total_ratings = total_ratings + 1
                        elif(int(new_rating) == 2):
                                number_of_type[1] = number_of_type[1] + 1
                                total_ratings = total_ratings + 1
                        elif (int(new_rating) == 3):
                                number_of_type[2] = number_of_type[2] + 1
                                total_ratings = total_ratings + 1
                        elif (int(new_rating) == 4):
                                number_of_type[3] = number_of_type[3] + 1
                                total_ratings = total_ratings + 1
                        elif (int(new_rating) == 5):
                                number_of_type[4] = number_of_type[4] + 1
                                total_ratings = total_ratings + 1
                    
                # Rounds the rating and stores the information to be sent back and updates
                rating = float((1 * number_of_type[0] + 2 * number_of_type[1] + 3 * number_of_type[2] + 4 * number_of_type[3] + 5 * number_of_type[4])/total_ratings)
                rating = round(rating,1)
                number_of_type.append(rating)
                number_of_type.append(total_ratings)
                return number_of_type
        username = ""
        rating = 0
        total_ratings = 0
        number_of_type = list({})

        data = contractor[0].split("|")
        username = data[0]
        rating = float(data[1])

        # Gathers types of rating and send it to function
        for x in range(5):
            number_of_type.append(int(data[x + 2]))
            total_ratings = total_ratings + number_of_type[x]
        rating_data = add_new_rating(number_of_type,total_ratings)


        # Puts new info together and overrides old info
        newInfo = str(username) + "|" + str(rating_data[-2]) + "|" + str(rating_data[0]) + "|" + str(rating_data[1]) + "|" + str(rating_data[2]) + "|" + str(rating_data[3]) + "|" + str(rating_data[4]) +  "|" + str(rating_data[-1])
        contractor[0] = newInfo








