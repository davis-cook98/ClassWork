# -*- coding: utf-8 -*-
"""

@author: Davis Cook and John Murzaku 
"""
#Code written to present at a school open house.
#Takes in an excel document and exports it as a
#choropleth map to plot.ly.
#My plotly projects are viewable at: https://plot.ly/~davisCook
import pandas as pd
import plotly.plotly as py

#Opens Excel document
#df should have the columns code, state, and total students.
#code is a strgin and is the state abbreviation.
#state is a string and is the state
#total students is an int stating the total number of students from the state
dfT = pd.read_excel("rsvpOH1.xlsx")
states = dfT["Address Region"].tolist()

#Puts all the state abbreviation in the dictionary
statesD = {}
for x in states:
    if x in statesD:
        statesD[x] += 1
    else:
        statesD[x] = 1




# Makes sure that the column heads are strings
for col in df.columns:
    df[col] = df[col].astype(str)

#Sets the scale for colors on the map. Because this was for an open house
#these colors are derivatives of the school colors.
scl = [[0.0, "rgb(162, 170, 173)"],[0.000001, "rgb(129, 149, 165)"],[0.001, "rgb(97, 129, 158)"],\
       [0.05, "rgb(64, 108, 150)"],[0.2, "rgb(32, 88, 143)"],[1.0, "rgb(0, 68, 136)"]]

#Defines the map
data = [ dict(
        type="choropleth",
        colorscale = scl,
        autocolorscale = False,
        locations = df["code"],
        z = df["total students"].astype(float),
        locationmode = "USA-states",
        marker = dict(
            line = dict (
                color = "rgb(255,255,255)",
                width = 2
            ) ),
        colorbar = dict(
            title = "Families")
        ) ]

#Defines the layout
layout = dict(
        title = "Where Everyone is From!",
        geo = dict(
            scope="usa",
            projection=dict( type="albers usa" ),
            showlakes = True,
            lakecolor = "rgb(255, 255, 255)"),
             )

#Makes the data readable by iplot and then exports it to Internet
fig = dict( data=data, layout=layout )
py.iplot( fig, filename="October 14th Open House" )
